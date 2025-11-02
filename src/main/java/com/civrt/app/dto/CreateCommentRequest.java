
package com.civrt.app.dto;

import lombok.Data;
import java.util.List;

@Data
public class CreateCommentRequest {
    private String by;
    private String text;
    private List<String> media;
}
