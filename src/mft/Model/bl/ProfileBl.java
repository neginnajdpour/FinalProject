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
        System.out.println("SERVICE :" +username+":"+password);

        try (ProfileDa profileDa = new ProfileDa()) {
            Optional<Profile> profile =  profileDa.getProfile(username , password);
            if(profile.isPresent()){
                System.out.println("SERVICE :" +profile);
                return profile.get();
            }
            else
                return null;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }


}
