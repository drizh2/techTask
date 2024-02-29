package com.dadry.techtask.payload.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

//@Data
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AsinReportRequest {
    @NotNull
    private List<String> parentAsins = new ArrayList<>();
}
