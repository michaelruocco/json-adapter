package uk.co.mruoc.json;

public interface JsonConverter {

    String toJson(Object object);

    <T> T toObject(String json, Class<T> type);

}
