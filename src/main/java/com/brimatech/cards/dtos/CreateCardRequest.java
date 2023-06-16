package com.brimatech.cards.dtos;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;

@Schema(
        description = "CreateCardRequest DTO Model Information"
)
public class CreateCardRequest {

    @Schema(
            description = "Card Name"
    )
    @JsonProperty("name")
    @NotEmpty(message = "card name is required")
    private String name;

    @Schema(
            description = "Card Color"
    )
    @JsonProperty("color")
    @Pattern(regexp = "^#[a-zA-Z0-9]{6}$",message = "Must start with # and must be alphanumeric of 6 characters")
    private String color;

    @Schema(
            description = "Card description"
    )
    @JsonProperty("description")
    private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    @Override
    public String toString() {
        return "CreateCardRequest { " +
                " name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
