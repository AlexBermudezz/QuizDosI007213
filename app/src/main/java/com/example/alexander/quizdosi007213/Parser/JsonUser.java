package com.example.alexander.quizdosi007213.Parser;

import com.example.alexander.quizdosi007213.Model.User;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alexander on 19/04/2018.
 */

public class JsonUser {

    public static List<User> getData(String content) throws JSONException {

        JSONArray jsonArray = new JSONArray(content);
        List<User> userList = new ArrayList<>();

        for (int i = 0; i < jsonArray.length(); i++){

            JSONObject item = jsonArray.getJSONObject(i);
            JSONObject street = item.getJSONObject("address");

            User user = new User();
            user.setName(item.getString("name"));
            user.setUserName(item.getString("username"));
            user.setEmail(item.getString("email"));
            user.setStreet(street.getString("street"));

            userList.add(user);
        }

        return userList;
    }

}

