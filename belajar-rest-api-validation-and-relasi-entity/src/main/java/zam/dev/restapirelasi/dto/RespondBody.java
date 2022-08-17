package zam.dev.restapirelasi.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class RespondBody<T> {

    private List<String> message = new ArrayList<>();

    private boolean status;

    private T data;


}
