package JsonLoading;

import com.google.gson.*;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/*
{
  "Linka A": {
    "1": {
      "name": "Nemocnice Motol",
      "transfer": []
    },
    "2": {
      "name": "Petriny",
      "transfer": []
    },

*/

class Metro {
    List<MetroLine> metroLines = new ArrayList<>();

    @Override
    public String toString() {
        return "Metro{" +
                "metroLines=" + metroLines +
                '}';
    }
}

class MetroLine {
    String name;
    Map<String, Station> stations = new HashMap<>();
}

class Station {
    String name;
    List<Station> transfer;

    public Station(String name, List<Station> transfer) {
        this.name = name;
        this.transfer = transfer;
    }
}

class MetroSerializer implements JsonSerializer<Metro> {
    @Override
    public JsonElement serialize(Metro src, Type typeOfSrc, JsonSerializationContext context) {
        JsonObject result = new JsonObject();
        for(MetroLine metroLine : src.metroLines) {
            result.add(metroLine.name, context.serialize(metroLine));
        }
        return result;
    }
}

class MetroLineSerializer implements JsonSerializer<MetroLine> {
    @Override
    public JsonElement serialize(MetroLine src, Type typeOfSrc, JsonSerializationContext context) {
        JsonObject result = new JsonObject();
        for(Map.Entry<String, Station> entry : src.stations.entrySet()) {
            result.add(entry.getKey(), context.serialize(entry.getValue()));
        }
        return result;
    }
}

class MetroDeserializer implements JsonDeserializer<Metro> {
    @Override
    public Metro deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject();
        MetroLine metroLine = new MetroLine();
        metroLine.stations = context.deserialize(jsonObject.get());
    }
}


public class Main {
    public static void main(String[] args) {
//        String json = "{ 'line': { '1':'station 1', '2':'station 2' } }";
//        String json = "{ 'name':'Aname', {'name':'Bname', 'nick':'Bnick'} }";
//        serialize();
        deserialize();


    }

    private static void deserialize() {
        Metro metro = new Gson().fromJson(metroJson, Metro.class);
        System.out.println(metro);
    }

    private static void serialize() {
        Metro metro = new Metro();
        MetroLine metroLine = new MetroLine();
        metroLine.name = "Linka A";
        metroLine.stations.put("1", new Station("Nemocnice Motol", List.of()));
        metroLine.stations.put("2", new Station("Petriny", List.of()));
        metro.metroLines.add(metroLine);

        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .registerTypeAdapter(Metro.class, new MetroSerializer())
                .registerTypeAdapter(MetroLine.class, new MetroLineSerializer())
                .create();
        String json = gson.toJson(metro);
        System.out.println(json);
    }

    static String metroJson = """
            {
              "Linka A": {
                "1": {
                  "name": "Nemocnice Motol",
                  "transfer": []
                },
                "2": {
                  "name": "Petriny",
                  "transfer": []
                },
                "3": {
                  "name": "Nadrazi Veleslavin",
                  "transfer": []
                },
                "4": {
                  "name": "Borislavka",
                  "transfer": []
                },
                "5": {
                  "name": "Dejvicka",
                  "transfer": []
                },
                "6": {
                  "name": "Hradcanska",
                  "transfer": []
                },
                "7": {
                  "name": "Malostranska",
                  "transfer": []
                },
                "8": {
                  "name": "Staromestska",
                  "transfer": []
                },
                "9": {
                  "name": "Mustek",
                  "transfer": [
                    {
                      "line": "Linka B",
                      "station": "Mustek"
                    }
                  ]
                },
                "10": {
                  "name": "Muzeum",
                  "transfer": [
                    {
                      "line": "Linka C",
                      "station": "Muzeum"
                    }
                  ]
                },
                "11": {
                  "name": "Namesti Miru",
                  "transfer": []
                },
                "12": {
                  "name": "Jiriho z Podebrad",
                  "transfer": []
                },
                "13": {
                  "name": "Flora",
                  "transfer": []
                },
                "14": {
                  "name": "Zelivskeho",
                  "transfer": []
                },
                "15": {
                  "name": "Strasnicka",
                  "transfer": []
                },
                "16": {
                  "name": "Skalka",
                  "transfer": []
                },
                "17": {
                  "name": "Depo Hostivar",
                  "transfer": []
                }
              },
              "Linka B": {
                "1": {
                  "name": "Cerny Most",
                  "transfer": []
                },
                "2": {
                  "name": "Rajska zahrada",
                  "transfer": []
                },
                "3": {
                  "name": "Hloubetin",
                  "transfer": []
                },
                "4": {
                  "name": "Kolbenova",
                  "transfer": []
                },
                "5": {
                  "name": "Vysocanska",
                  "transfer": []
                },
                "6": {
                  "name": "Ceskomoravska",
                  "transfer": []
                },
                "7": {
                  "name": "Palmovka",
                  "transfer": []
                },
                "8": {
                  "name": "Invalidovna",
                  "transfer": []
                },
                "9": {
                  "name": "Krizikova",
                  "transfer": []
                },
                "10": {
                  "name": "Florenc",
                  "transfer": [
                    {
                      "line": "Linka C",
                      "station": "Florenc"
                    }
                  ]
                },
                "11": {
                  "name": "Namesti Republiky",
                  "transfer": []
                },
                "12": {
                  "name": "Mustek",
                  "transfer": [
                    {
                      "line": "Linka B",
                      "station": "Mustek"
                    }
                  ]
                },
                "13": {
                  "name": "Narodni trida",
                  "transfer": []
                },
                "14": {
                  "name": "Karlovo namesti",
                  "transfer": []
                },
                "15": {
                  "name": "Andel",
                  "transfer": []
                },
                "16": {
                  "name": "Smichovske nadrazi",
                  "transfer": []
                },
                "17": {
                  "name": "Radlicka",
                  "transfer": []
                },
                "18": {
                  "name": "Jinonice",
                  "transfer": []
                },
                "19": {
                  "name": "Nove Butovice",
                  "transfer": []
                },
                "20": {
                  "name": "Hurka",
                  "transfer": []
                },
                "21": {
                  "name": "Luziny",
                  "transfer": []
                },
                "22": {
                  "name": "Luka",
                  "transfer": []
                },
                "23": {
                  "name": "Stodulky",
                  "transfer": []
                },
                "24": {
                  "name": "Zlicin",
                  "transfer": []
                }
              },
              "Linka C": {
                "1": {
                  "name": "Letnany",
                  "transfer": []
                },
                "2": {
                  "name": "Prosek",
                  "transfer": []
                },
                "3": {
                  "name": "Strizkov",
                  "transfer": []
                },
                "4": {
                  "name": "Ladvi",
                  "transfer": []
                },
                "5": {
                  "name": "Kobylisy",
                  "transfer": []
                },
                "6": {
                  "name": "Nadrazi Holesovice",
                  "transfer": []
                },
                "7": {
                  "name": "Vltavska",
                  "transfer": []
                },
                "8": {
                  "name": "Florenc",
                  "transfer": [
                    {
                      "line": "Linka B",
                      "station": "Florenc"
                    }
                  ]
                },
                "9": {
                  "name": "Hlavni nadrazi",
                  "transfer": []
                },
                "10": {
                  "name": "Muzeum",
                  "transfer": [
                    {
                      "line": "Linka A",
                      "station": "Muzeum"
                    }
                  ]
                },
                "11": {
                  "name": "I.P.Pavlova",
                  "transfer": []
                },
                "12": {
                  "name": "Vysehrad",
                  "transfer": []
                },
                "13": {
                  "name": "Prazskeho povstani",
                  "transfer": []
                },
                "14": {
                  "name": "Pankrac",
                  "transfer": []
                },
                "15": {
                  "name": "Budejovicka",
                  "transfer": []
                },
                "16": {
                  "name": "Kacerov",
                  "transfer": []
                },
                "17": {
                  "name": "Roztyly",
                  "transfer": []
                },
                "18": {
                  "name": "Chodov",
                  "transfer": []
                },
                "19": {
                  "name": "Opatov",
                  "transfer": []
                },
                "20": {
                  "name": "Haje",
                  "transfer": []
                }
              }
            }
                    """;
}
