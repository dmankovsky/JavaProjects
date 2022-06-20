package com.udacity.jwdnd.course1.cloudstorage.services;

import com.udacity.jwdnd.course1.cloudstorage.mapper.CredentialMapper;
import com.udacity.jwdnd.course1.cloudstorage.model.Credential;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.security.SecureRandom;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class CredentialService {

    @Autowired
    private final CredentialMapper credentialMapper;
    private final EncryptionService encryptionService;

    public CredentialService(CredentialMapper credentialMapper, EncryptionService encryptionService) {
        this.credentialMapper = credentialMapper;
        this.encryptionService = encryptionService;
    }

    @PostConstruct
    public void postConstruct(){
        System.out.println("Creating Credential-Service Bean.");
    }

    public List<Credential> getCredentialFromUserId(Integer userId){
        return credentialMapper.getFromUserId(userId);
    }

    public int addCredential(Credential credential){
        SecureRandom random = new SecureRandom();
        byte[] key = new byte[16];
        random.nextBytes(key);
        String encodedKey = Base64.getEncoder().encodeToString(key);
        String encryptedPassword = encryptionService.encryptValue(credential.getPassword(), encodedKey);
        credential.setKey(encodedKey);
        credential.setPassword(encryptedPassword);
        return credentialMapper.addCredential(credential);
    }

    public int editCredential (Credential credential){
        SecureRandom random = new SecureRandom();
        byte[] key = new byte[16];
        random.nextBytes(key);
        String encodedKey = Base64.getEncoder().encodeToString(key);
        String encryptedPassword = encryptionService.encryptValue(credential.getPassword(), encodedKey);
        credential.setKey(encodedKey);
        credential.setPassword(encryptedPassword);
        return credentialMapper.editCredential(credential);
    }

    public List<String> getDecryptedPasswordsFromUserId(Integer userFromId){
        List<Credential> listOfCredentials = getCredentialFromUserId(userFromId);
        if(listOfCredentials!=null){
            return listOfCredentials.stream().filter(Objects::nonNull)
                    .map(credential -> encryptionService.decryptValue(credential.getPassword(), credential.getKey()))
                    .collect(Collectors.toList());
        } else {
            return new ArrayList<>();
        }
    }
    public int deleteCredential (int credentialId){
        return credentialMapper.deleteCredential(credentialId);
    }

    public boolean isOnlyUsername (Integer userId, String userName){
        Optional<Credential> credential = Optional.ofNullable(credentialMapper.isOnlyUsername(userId, userName));
        return (credential.isEmpty());
    }
    public List<Credential> getFromUserId (Integer userId){
        return credentialMapper.getFromUserId(userId);
    }

}
