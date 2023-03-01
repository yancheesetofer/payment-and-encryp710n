package id.ac.ui.cs.advprog.tutorial3.Belanjaa.service;

import id.ac.ui.cs.advprog.tutorial3.Belanjaa.core.Item;
import id.ac.ui.cs.advprog.tutorial3.Belanjaa.core.adapter.CouponAdapter;
import id.ac.ui.cs.advprog.tutorial3.Belanjaa.core.adapter.GiftAdapter;
import id.ac.ui.cs.advprog.tutorial3.Belanjaa.core.payment.BelanjaaPayPayment;
import id.ac.ui.cs.advprog.tutorial3.Belanjaa.repository.CouponRepository;
import id.ac.ui.cs.advprog.tutorial3.Belanjaa.repository.GiftRepository;
import id.ac.ui.cs.advprog.tutorial3.Belanjaa.repository.ItemRepository;
import id.ac.ui.cs.advprog.tutorial3.Belanjaa.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import id.ac.ui.cs.advprog.tutorial3.Belanjaa.core.payment.Payment;

@Service
public class PaymentServiceImpl implements PaymentService{

    private final CouponRepository couponRepository;
    private final GiftRepository giftRepository;
    private final ItemRepository itemRepository;
    private final PaymentRepository paymentRepository;

    @Autowired
    public PaymentServiceImpl(CouponRepository couponRepository,
                              GiftRepository giftRepository,
                              ItemRepository itemRepository,
                              PaymentRepository paymentRepository) {
        this.couponRepository = couponRepository;
        this.giftRepository = giftRepository;
        this.itemRepository = itemRepository;
        this.paymentRepository = paymentRepository;
    }


    @Override
    public String makePayment(String itemName, String paymentCode) {
        // TODO: implement method, return value below if no payment is made
        Item item = itemRepository.getItem(itemName);

        if (item == null) {
            return "Item not found!";
        }

        if (paymentRepository.contains(itemName)) {
            return "Item already paid!";
        }

        String paymentResult;

        if (couponRepository.contains(paymentCode)) {
            CouponAdapter couponAdapter = new CouponAdapter(couponRepository.getCoupon(paymentCode));
            return couponAdapter.pay(item);
        } else if (giftRepository.contains(paymentCode)) {
            GiftAdapter giftAdapter = new GiftAdapter(giftRepository.getGift(paymentCode));
            return giftAdapter.pay(item);
        } else if (paymentRepository.contains(paymentCode)) {
            return paymentRepository.getPayment(paymentCode).pay(item);
        }

        return "Payment log is empty";
    }
}
