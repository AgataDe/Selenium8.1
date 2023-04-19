package handlers;

import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;
import models.User;

import java.util.Locale;

public class UserFactory {
    private FakeValuesService fakeValuesService = new FakeValuesService(new Locale("pl-PL"), new RandomService());
    private Faker faker = new Faker();


    public User getRandomUser() {
        return User.UserBuilder.builder()
                .firstName(faker.name().firstName())
                .lastName(faker.name().lastName())
                .email(fakeValuesService.bothify("????##@gmail.com"))
                .password(fakeValuesService.bothify("????##8129393hd"))
                .customerDataPrivacy(true)
                .generalConditionsPrivacy(true)
                .build();
    }

    public User getAlreadyRegisteredUser() {
        return new User.UserBuilder()
                .email(System.getProperty("registeredUserEmail"))
                .password(System.getProperty("registeredUserPassword"))
                .build();
    }


}
