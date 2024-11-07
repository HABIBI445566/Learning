package com.zahimuslim.Spring_boot_learning.entity;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Calendar;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
public class VerificationToken {

    private static final int EXPIRATION_TIME = 10;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String token;
//We generally give about 10 to 15 min of time for the token to expire
    private Date expirationTime;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id",
    nullable = false,
    foreignKey = @ForeignKey(name = "FK_USER_VERIFY_TOKEN"))
    private User user;


    public VerificationToken(User user, String token)
    {
        super();
        this.token = token;
        this.user = user;
        this.expirationTime = calculateExpirationDate();
    }

    private Date calculateExpirationDate()
    {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(new Date().getTime());
        cal.add(Calendar.MINUTE, VerificationToken.EXPIRATION_TIME);
        //check why two times?
        return new Date((cal.getTime().getTime()));
    }

    public VerificationToken(String token)
    {
        super();
        this.token = token;
        this.expirationTime = calculateExpirationDate();

    }



}
