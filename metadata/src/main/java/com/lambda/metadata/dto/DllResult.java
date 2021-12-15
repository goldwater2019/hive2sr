package com.lambda.metadata.dto;

import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class DllResult {
    public String message;
    public String dll;
}
