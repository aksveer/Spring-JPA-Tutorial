package com.springdemo.jpa.springjpatutorial.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Embeddable
@AttributeOverrides({
        @AttributeOverride(
                name = "name",
                column = @Column(name = "Guardian_Name")
        ),
        @AttributeOverride(
                name = "email",
                column = @Column(name = "Guardian_Email_Address")
        ),
        @AttributeOverride(
                name = "mobile",
                column = @Column(name = "Guardian_Mobile_Number")
        )
})
public class Guardian {
    private String name;
    private String email;
    private String mobile;
}
