/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forum.service;

import org.springframework.stereotype.Service;

/**
 *
 * @author ETY
 */
@Service
public class SecurityService {

    public boolean verifierAcces(String startwithtest,String monEcran) {
        if (monEcran.startsWith(startwithtest)) {
            return false;
        }

        return true;

    }

}
