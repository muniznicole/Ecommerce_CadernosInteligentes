package br.unitins.hello.service;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

import org.postgresql.shaded.com.ongres.scram.common.bouncycastle.pbkdf2.RuntimeCryptoException;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class HashServiceImpl implements HashService{

    private String salt = "#blahxyz22";
    private Integer iterationCount = 405;
    private Integer keyLength = 512;

    @Override
    public String getHashSenha(String senha) {
        try {
            byte[] result = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA512")
            .generateSecret(new PBEKeySpec(senha.toCharArray(),salt.getBytes(),iterationCount, keyLength)).getEncoded();
            
            return Base64.getEncoder().encodeToString(result);
        } catch (InvalidKeySpecException | NoSuchAlgorithmException e) {
            e.printStackTrace();
            throw new RuntimeCryptoException("Erro ao criar um hash");
        }
    }


public static void main(String[] args) {
        HashService service = new HashServiceImpl();
        System.out.println(service.getHashSenha("1234"));
    }
}