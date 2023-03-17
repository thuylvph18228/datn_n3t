package com.poly.users.DTO;

import com.poly.users.entity.Color;
import com.poly.users.entity.Height;
import com.poly.users.entity.Material;
import com.poly.users.entity.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class ProductDetailDto {

    private Integer id;

    private Integer productId;

    private Size size;

    private Color color;

    private Height height;

    private Integer quantity;

    private Material material;
}
