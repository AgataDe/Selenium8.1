package models;

import lombok.Data;

@Data
public class User {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private boolean customerDataPrivacy;
    private boolean generalConditionsPrivacy;


    public User(UserBuilder builder) {
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.email = builder.email;
        this.password = builder.password;
        this.customerDataPrivacy = builder.customerDataPrivacy;
        this.generalConditionsPrivacy = builder.generalConditionsPrivacy;

    }


    public static class UserBuilder {
        private String firstName;
        private String lastName;
        private String email;
        private String password;
        private boolean customerDataPrivacy;
        private boolean generalConditionsPrivacy;


        public UserBuilder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public UserBuilder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public UserBuilder email(String email) {
            this.email = email;
            return this;
        }

        public UserBuilder password(String password) {
            this.password = password;
            return this;
        }

        public UserBuilder customerDataPrivacy(boolean customerDataPrivacy) {
            this.customerDataPrivacy = customerDataPrivacy;
            return this;
        }

        public UserBuilder generalConditionsPrivacy(boolean generalConditionsPrivacy) {
            this.generalConditionsPrivacy = generalConditionsPrivacy;
            return this;
        }


        public static UserBuilder builder() {
            return new UserBuilder();
        }

        public User build() {
            return new User(this);
        }
    }

}
