package mft.Model.bl;

import mft.Model.da.ProfileDa;
import mft.Model.entity.Profile;

import java.util.Optional;

public class ProfileBl {

    public static void remove(String username){
        try (ProfileDa profileDa = new ProfileDa()) {
            profileDa.remove(username);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static Profile getProfile(String username , String password){
        try (ProfileDa profileDa = new ProfileDa()) {
            Optional<Profile> profile =  profileDa.getProfile(username , password);
            if(profile.isPresent()){
                return profile.get();
            }
            else
                return null;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }


}
