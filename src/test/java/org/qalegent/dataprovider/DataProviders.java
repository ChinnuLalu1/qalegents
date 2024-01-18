package org.qalegent.dataprovider;

import org.testng.annotations.DataProvider;

public class DataProviders {
    @DataProvider(name="verifyInvalidLoginCredentials")
    public Object[][] userCredentialsData(){
        Object[][] data =new Object[3][2];
        data[0][0]="123@gmail.com";
        data[0][1]="abc123";

        data[1][0]="123@gmail.com";
        data[1][1]="123abc";

        data[2][0]="abc@gmail.com";
        data[2][1]="abc123";
        return data;
    }
}
