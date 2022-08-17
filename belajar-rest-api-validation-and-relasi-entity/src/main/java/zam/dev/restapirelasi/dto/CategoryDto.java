package zam.dev.restapirelasi.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;


@Data
public class CategoryDto {

    @NotBlank(message = "nama category is required")
    private String nama_kategori;

}
