package com.fsse2305.eshop_project.utility;

import com.fsse2305.eshop_project.data.user.domainObject.FirebaseUserData;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;

public class JwtUtil {
    public static FirebaseUserData getFirebaseUserData(JwtAuthenticationToken jwtToken){
        return new FirebaseUserData(jwtToken);

    }
}
