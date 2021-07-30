import org.junit.Before;
import org.junit.Test;
import com.geekcolab.development.util.FunctionUtil;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.*;

public class FunctionUtilTest {

    Shop yamShopping;

    List<Discount> firstDiscounts, secondDiscounts;
    List<Limit> firstLimits, secondLimits, thirdLimits, fourthLimits;
    Tag blackColourTag, redColourTag, mediumPinkTag, largeGreenTag;

    List<Product> firstProducts, secondProducts, thirdProducts, fourthProducts;
    Order firstOrder, secondOrder, thirdOrder, fourthOrder;
    Payment firstPayment, secondPayment, thirdPayment, fourthPayment;

    List<Staff> staffs;
    List<Customer> customers;

    Customer customerAbdi, customerWinta, customerTerbinios, customerFkadu, customerNeba;
    Staff staffAbdi, staffYoseph, staffMerone, staffSofi, staffAlazar;

    @Before
    public void setUp() {

        //creating tags
        blackColourTag = TestFactory.createTag("Black Color");
        redColourTag = TestFactory.createTag("Red Color");
        mediumPinkTag = TestFactory.createTag("Medium Pink Color");
        largeGreenTag = TestFactory.createTag("Large Green Color");

        //creating discounts
        firstDiscounts = List.of(
                TestFactory.createDiscount("Summer Deal", 2, 3)
        );
        secondDiscounts = List.of(
                TestFactory.createDiscount("Summer Deal", 2, 3),
                TestFactory.createDiscount("Holiday Deals", 5, 1)
        );

        //creating discounts
        firstLimits = List.of(
                TestFactory.createLimit("min", 1),
                TestFactory.createLimit("max", 10),
                TestFactory.createLimit("daily", 10)
        );
        secondLimits = List.of(
                TestFactory.createLimit("min", 1),
                TestFactory.createLimit("max", 10)
        );
        thirdLimits = List.of(
                TestFactory.createLimit("max", 10)
        );
        fourthLimits = List.of(
                TestFactory.createLimit("max", 100)
        );

        //creating products
        firstProducts = List.of(
                TestFactory.createProduct("T-shirt", "Clothes", "...", firstDiscounts, blackColourTag, firstLimits),
                TestFactory.createProduct("Pants", "Clothes", "...", secondDiscounts, blackColourTag, secondLimits)
        );

        secondProducts = List.of(
                TestFactory.createProduct("Jackets", "Clothes", "...", firstDiscounts, redColourTag, firstLimits),
                TestFactory.createProduct("WebCam", "Electronics", "...", new ArrayList<>(), blackColourTag, new ArrayList<>()),
                TestFactory.createProduct("Keyboard", "Electronics", "...", new ArrayList<>(), mediumPinkTag, thirdLimits)
        );

        thirdProducts = List.of(
                TestFactory.createProduct("Lamp", "Gadgets", "...", new ArrayList<>(), mediumPinkTag, fourthLimits),
                TestFactory.createProduct("Desk Clock", "Gadgets", "...", new ArrayList<>(), blackColourTag, fourthLimits),
                TestFactory.createProduct("Outlet", "Gadgets", "...", new ArrayList<>(), redColourTag, fourthLimits)
        );

        fourthProducts = List.of(
                TestFactory.createProduct("Pencil", "Stationary", "...", new ArrayList<>(), blackColourTag, new ArrayList<>()),
                TestFactory.createProduct("Prince Pen", "Stationary", "...", new ArrayList<>(), blackColourTag, fourthLimits),
                TestFactory.createProduct("Staple", "Stationary", "...", new ArrayList<>(), blackColourTag, fourthLimits)
        );

        //creating staffs
        staffs = List.of(
                staffAbdi = TestFactory.createStaff("Abdi", "T"),
                staffYoseph = TestFactory.createStaff("Yoseph", "B"),
                staffMerone = TestFactory.createStaff("Meron", "G"),
                staffSofi = TestFactory.createStaff("Sofia", "A"),
                staffAlazar = TestFactory.createStaff("Alazar", "K")
        );



        //creating customers
        customers = List.of(
                customerAbdi = TestFactory.createCustomer("Abdi", "T", "abdi@g.com"),
                customerWinta = TestFactory.createCustomer("Winta", "Y", "winta@g.com"),
                customerTerbinios = TestFactory.createCustomer("Terbinios", "T", "terbinios@g.com"),
                customerFkadu = TestFactory.createCustomer("Fkadu", "S", "fkadu@g.com"),
                customerNeba = TestFactory.createCustomer("Neba", "H", "neba@g.com")
        );


        //createPayment
        firstPayment = TestFactory.createPayment(12d, 2200);
        secondPayment = TestFactory.createPayment(15d, 5200);
        thirdPayment = TestFactory.createPayment(20d, 8600);
        fourthPayment = TestFactory.createPayment(2d, 250);

        //creating Orders
        firstOrder = TestFactory.createOrder(LocalDateTime.now(), firstPayment);
        secondOrder = TestFactory.createOrder(LocalDateTime.now(), secondPayment);
        thirdOrder = TestFactory.createOrder(LocalDateTime.now(), thirdPayment);
        fourthOrder = TestFactory.createOrder(LocalDateTime.now(), fourthPayment);

        //assignPayment
        firstPayment = TestFactory.assignPayment(firstPayment, firstOrder, firstProducts);
        secondPayment = TestFactory.assignPayment(secondPayment, secondOrder, secondProducts);
        thirdPayment = TestFactory.assignPayment(thirdPayment, thirdOrder, thirdProducts);
        fourthPayment = TestFactory.assignPayment(fourthPayment, fourthOrder, fourthProducts);

        //assign orders for Customer
        customerAbdi = TestFactory.assignCustomer(customerAbdi, List.of(firstOrder, thirdOrder));
        customerWinta = TestFactory.assignCustomer(customerWinta, List.of(fourthOrder));
        customerNeba = TestFactory.assignCustomer(customerNeba, List.of(secondOrder));

        firstOrder = TestFactory.assignOrder(firstOrder, List.of(customerAbdi));
        thirdOrder = TestFactory.assignOrder(thirdOrder, List.of(customerAbdi));
        fourthOrder = TestFactory.assignOrder(firstOrder, List.of(customerWinta));
        secondOrder = TestFactory.assignOrder(secondOrder, List.of(customerNeba));

        staffYoseph = TestFactory.assignStaff(staffYoseph, List.of(firstOrder, fourthOrder));
        staffMerone = TestFactory.assignStaff(staffMerone, List.of(thirdOrder));
        staffSofi = TestFactory.assignStaff(staffSofi, List.of(secondOrder));

        //creating shop
        yamShopping = TestFactory.createShop("YAM", Stream.concat(firstProducts.stream(), secondProducts.stream()).collect(Collectors.toList()), staffs);

    }

    @Test
    public void testFromPersonsToCustomers() {
        assertEquals(List.of(customerAbdi, customerWinta), FunctionUtil.fromPersonsToCustomers.apply(List.of(customerAbdi.getPerson(), customerWinta.getPerson())));
        assertEquals(List.of(customerNeba, customerTerbinios), FunctionUtil.fromPersonsToCustomers.apply(List.of(customerNeba.getPerson(), customerTerbinios.getPerson())));

        assertNotEquals(List.of(staffAbdi, customerWinta), FunctionUtil.fromPersonsToCustomers.apply(List.of(customerAbdi.getPerson(), customerWinta.getPerson())));
        assertNotEquals(List.of(customerNeba, customerTerbinios), FunctionUtil.fromPersonsToCustomers.apply(List.of(customerTerbinios.getPerson(), customerNeba.getPerson())));
        assertNotEquals(List.of(staffSofi, staffYoseph), FunctionUtil.fromPersonsToCustomers.apply(List.of(staffMerone.getPerson(), staffYoseph.getPerson())));
    }

    @Test
    public void testFromPersonsToStaff() {
        assertEquals(List.of(staffAlazar), FunctionUtil.fromPersonsToStaff.apply(List.of(staffAlazar.getPerson())));
        assertEquals(List.of(staffSofi, staffYoseph), FunctionUtil.fromPersonsToStaff.apply(List.of(staffSofi.getPerson(), staffYoseph.getPerson())));
        assertNotEquals(List.of(staffAbdi, customerWinta), FunctionUtil.fromPersonsToStaff.apply(List.of(customerAbdi.getPerson(), customerWinta.getPerson())));
        assertNotEquals(List.of(staffSofi, staffYoseph), FunctionUtil.fromPersonsToStaff.apply(List.of(staffMerone.getPerson(), staffYoseph.getPerson())));
    }

    @Test
    public void testDiscountsMade() {

        Optional<Double> result;

        assertEquals(Optional.of(Stream.concat(firstDiscounts.stream(), secondDiscounts.stream()).mapToDouble(discount -> discount.getDiscountPercent()).sum())
                , FunctionUtil.discountsMade.apply(firstPayment));

        result = FunctionUtil.discountsMade.apply(secondPayment);
        assertEquals(firstDiscounts.stream().map(discount -> discount.getDiscountPercent()).findFirst(), result);

        result = FunctionUtil.discountsMade.apply(fourthPayment);
        assertEquals(Optional.ofNullable(null), result);

        assertNotEquals(Optional.of(secondDiscounts).get(), FunctionUtil.discountsMade.apply(secondPayment));
        assertNotEquals(Optional.of(firstDiscounts).get(), FunctionUtil.discountsMade.apply(fourthPayment));
    }

    @Test
    public void testTopPayingCustomersWithMoreThanKDiscounts() {

        Optional<Double> result;

        result = FunctionUtil.topPayingCustomersWithMoreThanKDiscounts.apply(customerAbdi, 2021L, 0d);
        assertEquals(Optional.ofNullable(firstPayment.getSubTotal()), result);


        result = FunctionUtil.topPayingCustomersWithMoreThanKDiscounts.apply(customerWinta, 2021L, 0d);
        assertNotEquals(Optional.ofNullable(250), result);

    }

    @Test
    public void testTopKPayingCustomersOnKDiscounts() {

        List<String> result;

        result = FunctionUtil.topKPayingCustomersOnKDiscounts.apply(List.of(customerAbdi.getPerson(), customerWinta.getPerson(),customerNeba.getPerson(), customerFkadu.getPerson(), customerTerbinios.getPerson()), 2021L, 0d, 5L);
        assertEquals(result,
                List.of(
                        customerNeba.getPerson().getFirstName() + " " + customerNeba.getPerson().getLastName(),
                        customerAbdi.getPerson().getFirstName() + " " + customerAbdi.getPerson().getLastName()
                ));


        result = FunctionUtil.topKPayingCustomersOnKDiscounts.apply(List.of(customerAbdi.getPerson(), customerWinta.getPerson(),customerNeba.getPerson(), customerFkadu.getPerson(), customerTerbinios.getPerson()), 2021L, 0d, 5L);
        assertNotEquals(result,
                List.of(
                        customerAbdi.getPerson().getFirstName() + " " + customerAbdi.getPerson().getLastName(),
                        customerWinta.getPerson().getFirstName() + " " + customerWinta.getPerson().getLastName(),
                        customerNeba.getPerson().getFirstName() + " " + customerNeba.getPerson().getLastName()
                ));

    }

    @Test
    public void testTopKMostTaxedProductOnKYear() {

        List<String> result;


        result = FunctionUtil.topKMostTaxedProductOnKYear.apply(yamShopping, 2021L, 4L);
        assertEquals(result,
                List.of(
                        "Lamp",
                        "Desk Clock",
                        "Outlet",
                        "Jackets"
                ));


        result = FunctionUtil.topKMostTaxedProductOnKYear.apply(yamShopping, 2021L, 3L);
        assertEquals(result,
                List.of(
                        "Lamp",
                        "Desk Clock",
                        "Outlet"
                ));


        result = FunctionUtil.topKMostTaxedProductOnKYear.apply(yamShopping, 2021L, 3L);
        assertNotEquals(result,
                List.of(
                        "Lamp",
                        "Desk Clock",
                        "Outlet",
                        "Jackets"
                ));


        result = FunctionUtil.topKMostTaxedProductOnKYear.apply(yamShopping, 2021L, 1L);
        assertNotEquals(result,
                List.of(
                        "Jackets"
                ));

    }

    @Test
    public void testTopTaxPayingCustomerOnKYear() {

        List<String> result;


        result = FunctionUtil.topTaxPayingCustomerOnKYear.apply(yamShopping, 2021L, 4L);
        assertEquals(result,
                List.of(
                        "Abdi T",
                        "Neba H",
                        "Winta Y"
                ));


        result = FunctionUtil.topTaxPayingCustomerOnKYear.apply(yamShopping, 2021L, 1L);
        assertEquals(result,
                List.of(
                        "Abdi T"
                        ));


        result = FunctionUtil.topTaxPayingCustomerOnKYear.apply(yamShopping, 2021L, 2L);
        assertEquals(result,
                List.of(
                        "Abdi T",
                        "Neba H"
                        ));


        result = FunctionUtil.topTaxPayingCustomerOnKYear.apply(yamShopping, 2021L, 3L);
        assertNotEquals(result,
                List.of(
                        "Lamp",
                        "Desk Clock",
                        "Outlet"
                ));

    }

}


