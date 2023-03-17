package com.poly.users.DTO;

import com.poly.users.entity.PromotionBlacklist;
import com.poly.users.entity.PromotionCategory;
import com.poly.users.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class PromotionDto {

    private Integer id;

    private String name;

    private Integer quantity;

    private LocalDate beginDate;

    private LocalDate endDate;

    private String status;

    private User createBy;

    private User updateBy;

    private List<PromotionCategory> promotionCategories;

    private List<PromotionBlacklist> promotionBlacklists;

}
