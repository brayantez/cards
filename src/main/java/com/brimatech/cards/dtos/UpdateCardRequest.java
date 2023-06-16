package com.brimatech.cards.dtos;

import com.brimatech.cards.models.Card;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@Schema(
        description = "UpdateCardRequest DTO Model Information"
)
public class UpdateCardRequest {

    @Schema(
            description = "Card Name"
    )
    @JsonProperty("name")
    @NotBlank(message = "card name is required")
    private String name;

    @Schema(
            description = "Card color"
    )
    @JsonProperty("color")
    @Pattern(regexp = "^#[a-zA-Z0-9]{6}$|",message = "Must start with # and must be alphanumeric of 6 characters")
    private String color;

    @Schema(
            description = "Card description"
    )
    @JsonProperty("description")
    private String description;

    @Schema(
            description = "Card status"
    )
    @NotNull(message = "status is required")
    @JsonProperty("status")
    private Card.Status status;

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

    public Card.Status getStatus() {
        return status;
    }

    public void setStatus(Card.Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "UpdateCardRequest{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", description='" + description + '\'' +
                ", status=" + status +
                '}';
    }






}
