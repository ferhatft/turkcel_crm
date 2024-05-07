package com.turkcell.core.service.constants;

public class Messages {




    public static class ValidationErrors{
        public static final String FIELD_NOT_BLANK = "{field.notBlank}";
        public static final String FIELD_NOT_NULL = "{field.notNull}";
        public static final String SIZE_INVALID ="{field.inValid}";
    }

    public static class BusinessErrors{
        public static final String CUSTOMER_NATID_EXIST = "customer.NatIdExist";

        public static final String CUSTOMER_NOT_EXIST = "customer.notExist";

        public static final String CUSTOMER_EXIST_WITH_SAME_NATID= "customer.existWithSameNationalityId";

        public static final String CUSTOMER_HAS_PRODUCT = "customer.hasProduct";
        public static final String CUSTOMER_WITH_THAT_ID_NOT_EXIST="customer.withThatIdNotExist";

        public static final String CUSTOMER_HAS_NOT_MORE_THAN_ONE_ADDRESS = "customer.hasNotMoreThanOneAddress";
        public static final String ADDRESS_DOES_NOT_EXIST = "address.doesNotExist";
        public static final String ACCOUNT_HAS_PRODUCT = "account.hasProduct";

        public static final String ACCOUNT_DELETED = "account.deleted";

        public static final String CONTACT_DOES_NOT_EXIST = "contact.doesNotExist";
        public static final String CONTACT_HAS_ALREADY_EXIST = "contact.alreadyHasContact";
        public static final String PRODUCT_DOES_NOT_EXIST = "product.doesNotExist";
        public static final String PRODUCT_WITH_THIS_PRODUCTNO_ALREADY_EXIST = "product.thisProductNoAlreadyExist";
        public static final String THIS_ADDRESS_NOT_BELONG_THIS_CUSTOMER = "address.thisAddressNotBelongThisCustomer";
        public static final String ACCOUNT_DOES_NOT_EXIST = "account.doesNotExist";
    }
}
