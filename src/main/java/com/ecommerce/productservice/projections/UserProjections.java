package com.ecommerce.productservice.projections;

public interface UserProjections {

    interface BasicInfo {
        String getName();
        String getEmail();
    }

    interface DetailedInfo {
        String getName();
        String getEmail();
        String getAddress();
    }

}
