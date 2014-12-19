package utility;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.lang.reflect.Array;

/**
 * Created by Gökhan on 11/19/2014.
 */
public class GsonUtility {
    // basic class utility methods
    public static <T> String convertJson(T model) {
        GsonBuilder builder = new GsonBuilder();
        String json = builder.create().toJson(model);
        return json;
    }

    public static <T> String convertJson(T[][] t) {
        String entity = null;
        Gson builder = new Gson();
        entity = builder.toJson(t);
        return entity;
    }

    public static <T> T getObject(String entity, Class<T> c) {
        GsonBuilder builder = new GsonBuilder();
        T obj = (builder.create().fromJson(entity, c));
        return obj;
    }


    public static <T> T[] getArray(final String entity, final Class<T> c) {

        GsonBuilder builder = new GsonBuilder();
        T[] array = (T[]) Array.newInstance(c, 0);
        T[] objArray = (T[]) builder.create()
                .fromJson(entity, array.getClass());

        return objArray;
    }

    public static <T> T[][] getMultiArray(final String entity, final Class<T> c) {

        GsonBuilder builder = new GsonBuilder();
        T[][] array = (T[][]) Array.newInstance(c, 0);
        T[][] objArray = (T[][]) builder.create()
                .fromJson(entity, array.getClass());

        return objArray;
    }
}
