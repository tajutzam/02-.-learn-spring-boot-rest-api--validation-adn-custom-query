package zam.dev.restapirelasi.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class UpdateProductDto {

    private Long id;
    @NotEmpty(message = "Name can not empty")
    private String name_product;

    @NotEmpty(message = "Description can not empty")
    private String description;

    @NotNull(message = "Prize can not null")
    private double prize;
}
