package com.poly.users.DTO;

import com.poly.users.entity.Product;
import com.poly.users.entity.User;
import com.poly.users.entity.Product;
import com.poly.users.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@SuperBuilder
public class FeedBackDto {

    private Integer id;

    private Product product;

    private User user;

    private String feedback;

    private Integer stars;

}
