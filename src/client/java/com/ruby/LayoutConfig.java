package com.ruby;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import net.minecraft.client.Minecraft;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class LayoutConfig {

    private final File file = new File(
            new File(Minecraft.getInstance().gameDirectory, "config"),
            "mycreativelayout.json"
    );

    public boolean load() {
        if (!file.exists()) return false;
        try (FileReader reader = new FileReader(file)) {
            JsonObject obj = new Gson().fromJson(reader, JsonObject.class);
            return obj.get("isMyLayout").getAsBoolean();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void save(boolean isMyLayout) {
        try {
            if (!file.getParentFile().exists()) file.getParentFile().mkdirs();
            try (FileWriter writer = new FileWriter(file)) {
                JsonObject obj = new JsonObject();
                obj.addProperty("isMyLayout", isMyLayout);
                new Gson().toJson(obj, writer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
