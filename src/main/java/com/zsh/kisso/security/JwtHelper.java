
package com.zsh.kisso.security;

import java.security.Key;
import java.security.KeyStore;

import com.zsh.kisso.common.RsaKeyHelper;
import com.zsh.kisso.common.SSOConstants;
import com.zsh.kisso.exception.KissoException;
import com.zsh.kisso.SSOConfig;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.FileCopyUtils;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/**
 * <p>
 * SSO Token 签名验证辅助类
 * </p>
 *
 * @author zhaoshihao
 * @since 2017-07-19
 */
public class JwtHelper {

    /**
     * <p>
     * 签名并生成 Token
     * </p>
     */
    public static String signCompact(JwtBuilder jwtBuilder) {
        SSOConfig config = SSOConfig.getInstance();
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.forName(config.getSignAlgorithm());
        if (SSOConstants.SIGN_RSA.equals(signatureAlgorithm.getFamilyName())) {
            try {
                ClassPathResource resource = new ClassPathResource(config.getRsaKeystore());
                KeyStore keystore = KeyStore.getInstance(KeyStore.getDefaultType());
                keystore.load(resource.getInputStream(), config.getRsaStorepass().toCharArray());
                Key key = keystore.getKey(config.getRsaAlias(), config.getRsaKeypass().toCharArray());
                // RSA 签名
                return jwtBuilder.signWith(signatureAlgorithm, key).compact();
            } catch (Exception e) {
                throw new KissoException("signCompact error.", e);
            }
        }
        // 普通签名
        return jwtBuilder.signWith(signatureAlgorithm, config.getSignkey()).compact();
    }


    /**
     * <p>
     * 验证签名并解析
     * </p>
     */
    public static JwtParser verifyParser() {
        try {
            SSOConfig config = SSOConfig.getInstance();
            SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.forName(config.getSignAlgorithm());
            if (SSOConstants.SIGN_RSA.equals(signatureAlgorithm.getFamilyName())) {
                ClassPathResource resource = new ClassPathResource(config.getRsaCertstore());
                String publicKey = new String(FileCopyUtils.copyToByteArray(resource.getInputStream()));
                // RSA 签名验证
                return Jwts.parser().setSigningKey(RsaKeyHelper.parsePublicKey(publicKey));
            }
            // 普通签名验证
            return Jwts.parser().setSigningKey(config.getSignkey());
        } catch (Exception e) {
            throw new KissoException("verifyParser error.", e);
        }
    }
}
