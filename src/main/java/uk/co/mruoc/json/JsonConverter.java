package uk.co.mruoc.json;

public interface JsonConverter {

    String toJson(final Object object);

    <T> T toObject(final String json, final Class<T> type);

}
