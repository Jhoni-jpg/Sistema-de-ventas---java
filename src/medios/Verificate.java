package medios;

import java.util.HashMap;

public class Verificate {

    public boolean verificarCodigo(HashMap<String, String> mapa, String correo, String codigoRecibido) {
        if (mapa.containsKey(correo)) {
            String codigoGuardado = mapa.get(correo);
            return codigoGuardado.equals(codigoRecibido);
        }
        return false;
    }

    public boolean isValidDNI(String dni) {

        if (dni.length() != 10) {
            return false;
        }

        for (char c : dni.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }

        return true;
    }

    public boolean isValidEmail(String email) {
//        try {
//            InternetAddress emailAddr = new InternetAddress(email);
//            emailAddr.validate();
//        } catch (AddressException e) {
//            System.out.println(e.getMessage());
//        }
        
        String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        return email.matches(emailRegex);
    }

    public boolean isValidPhoneNumber(String phoneNumber) {

        String phoneRegex = "^\\d{9}$"; // 9 dígitos
        return phoneNumber.matches(phoneRegex);
    }

    public boolean isValidName(String name) {

        String nameRegex = "^[a-zA-Z\\s]+$";
        return name.matches(nameRegex);
    }

    public boolean isValidAddress(String address) {

        return !address.trim().isEmpty();
    }

    public boolean isValidPassword(String password) {

        return password.length() >= 8;
    }

    public boolean isValidUsername(String username) {

        return username.length() >= 3;
    }

    public boolean isValidPrivilege(String privilege) {

        return !privilege.trim().isEmpty();
    }

    public boolean isValidDate(String date) {

        return !date.trim().isEmpty();
    }

    public boolean isValidId(int id) {

        return id > 0;
    }

}
