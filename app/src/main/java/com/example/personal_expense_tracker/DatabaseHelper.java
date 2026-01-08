package com.example.personal_expense_tracker;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "quiz_app.db";
    private static final int DB_VERSION = 1;

    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE users (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "username TEXT," +
                "email TEXT," +
                "password TEXT)");

        db.execSQL("CREATE TABLE questions (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "question TEXT," +
                "answer TEXT," +
                "quiz_type TEXT)");

        db.execSQL("CREATE TABLE results (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "user_id INTEGER," +
                "quiz_type TEXT," +
                "score INTEGER," +
                "total INTEGER," +
                "date TEXT)");

        insertSampleQuestions(db);
    }

    private void insertSampleQuestions(SQLiteDatabase db) {
        // SCIENCE (100 Questions)
        db.execSQL("INSERT INTO questions VALUES (null,'What is H2O?','water','SCIENCE')");
        db.execSQL("INSERT INTO questions VALUES (null,'Gas used for breathing?','oxygen','SCIENCE')");
        db.execSQL("INSERT INTO questions VALUES (null,'Powerhouse of the cell?','mitochondria','SCIENCE')");
        db.execSQL("INSERT INTO questions VALUES (null,'Red planet name?','mars','SCIENCE')");
        db.execSQL("INSERT INTO questions VALUES (null,'Boiling point of water in Celsius?','100','SCIENCE')");
        db.execSQL("INSERT INTO questions VALUES (null,'Hardest natural substance?','diamond','SCIENCE')");
        db.execSQL("INSERT INTO questions VALUES (null,'Planet closest to the sun?','mercury','SCIENCE')");
        db.execSQL("INSERT INTO questions VALUES (null,'Human body normal temp in Celsius?','37','SCIENCE')");
        db.execSQL("INSERT INTO questions VALUES (null,'Study of plants?','botany','SCIENCE')");
        db.execSQL("INSERT INTO questions VALUES (null,'Gas that makes up 78% of air?','nitrogen','SCIENCE')");
        db.execSQL("INSERT INTO questions VALUES (null,'Nearest star to Earth?','sun','SCIENCE')");
        db.execSQL("INSERT INTO questions VALUES (null,'Chemical symbol for Gold?','au','SCIENCE')");
        db.execSQL("INSERT INTO questions VALUES (null,'Type of lens in human eye?','convex','SCIENCE')");
        db.execSQL("INSERT INTO questions VALUES (null,'Unit of electrical resistance?','ohm','SCIENCE')");
        db.execSQL("INSERT INTO questions VALUES (null,'Who proposed theory of relativity?','einstein','SCIENCE')");
        db.execSQL("INSERT INTO questions VALUES (null,'Metal liquid at room temp?','mercury','SCIENCE')");
        db.execSQL("INSERT INTO questions VALUES (null,'Acid in lemons?','citric','SCIENCE')");
        db.execSQL("INSERT INTO questions VALUES (null,'Part of plant for photosynthesis?','leaf','SCIENCE')");
        db.execSQL("INSERT INTO questions VALUES (null,'Number of bones in adult human?','206','SCIENCE')");
        db.execSQL("INSERT INTO questions VALUES (null,'Planet with rings?','saturn','SCIENCE')");
        db.execSQL("INSERT INTO questions VALUES (null,'Sound travels fastest in?','solids','SCIENCE')");
        db.execSQL("INSERT INTO questions VALUES (null,'Force keeping us on ground?','gravity','SCIENCE')");
        db.execSQL("INSERT INTO questions VALUES (null,'Smallest unit of life?','cell','SCIENCE')");
        db.execSQL("INSERT INTO questions VALUES (null,'Gas plants absorb?','carbon dioxide','SCIENCE')");
        db.execSQL("INSERT INTO questions VALUES (null,'Vitamin from sunlight?','vitamin d','SCIENCE')");
        db.execSQL("INSERT INTO questions VALUES (null,'Largest organ in body?','skin','SCIENCE')");
        db.execSQL("INSERT INTO questions VALUES (null,'Liquid turning to gas?','evaporation','SCIENCE')");
        db.execSQL("INSERT INTO questions VALUES (null,'Symbol for Silver?','ag','SCIENCE')");
        db.execSQL("INSERT INTO questions VALUES (null,'Main gas in Sun?','hydrogen','SCIENCE')");
        db.execSQL("INSERT INTO questions VALUES (null,'Center of an atom?','nucleus','SCIENCE')");
        db.execSQL("INSERT INTO questions VALUES (null,'Device to measure earthquakes?','seismograph','SCIENCE')");
        db.execSQL("INSERT INTO questions VALUES (null,'Color of chlorophyll?','green','SCIENCE')");
        db.execSQL("INSERT INTO questions VALUES (null,'Human blood pH level approx?','7.4','SCIENCE')");
        db.execSQL("INSERT INTO questions VALUES (null,'Brain part for balance?','cerebellum','SCIENCE')");
        db.execSQL("INSERT INTO questions VALUES (null,'Earths natural satellite?','moon','SCIENCE')");
        db.execSQL("INSERT INTO questions VALUES (null,'Dry ice is solid form of?','carbon dioxide','SCIENCE')");
        db.execSQL("INSERT INTO questions VALUES (null,'Most abundant metal in Earth crust?','aluminum','SCIENCE')");
        db.execSQL("INSERT INTO questions VALUES (null,'Atmospheric layer with Ozone?','stratosphere','SCIENCE')");
        db.execSQL("INSERT INTO questions VALUES (null,'SI unit of Force?','newton','SCIENCE')");
        db.execSQL("INSERT INTO questions VALUES (null,'First man in space?','yuri gagarin','SCIENCE')");
        db.execSQL("INSERT INTO questions VALUES (null,'Discovered Penicillin?','alexander fleming','SCIENCE')");
        db.execSQL("INSERT INTO questions VALUES (null,'Master gland?','pituitary','SCIENCE')");
        db.execSQL("INSERT INTO questions VALUES (null,'Galaxy we live in?','milky way','SCIENCE')");
        db.execSQL("INSERT INTO questions VALUES (null,'Largest planet?','jupiter','SCIENCE')");
        db.execSQL("INSERT INTO questions VALUES (null,'Gas in fire extinguishers?','carbon dioxide','SCIENCE')");
        db.execSQL("INSERT INTO questions VALUES (null,'Study of insects?','entomology','SCIENCE')");
        db.execSQL("INSERT INTO questions VALUES (null,'Purest form of carbon?','diamond','SCIENCE')");
        db.execSQL("INSERT INTO questions VALUES (null,'Unit of Power?','watt','SCIENCE')");
        db.execSQL("INSERT INTO questions VALUES (null,'Lightest element?','hydrogen','SCIENCE')");
        db.execSQL("INSERT INTO questions VALUES (null,'Common name for NaCl?','salt','SCIENCE')");
        db.execSQL("INSERT INTO questions VALUES (null,'Study of fossils?','paleontology','SCIENCE')");
        db.execSQL("INSERT INTO questions VALUES (null,'Human heart chambers?','4','SCIENCE')");
        db.execSQL("INSERT INTO questions VALUES (null,'Smallest planet?','mercury','SCIENCE')");
        db.execSQL("INSERT INTO questions VALUES (null,'Gas humans exhale?','carbon dioxide','SCIENCE')");
        db.execSQL("INSERT INTO questions VALUES (null,'DNA shape?','double helix','SCIENCE')");
        db.execSQL("INSERT INTO questions VALUES (null,'Study of weather?','meteorology','SCIENCE')");
        db.execSQL("INSERT INTO questions VALUES (null,'Hottest planet?','venus','SCIENCE')");
        db.execSQL("INSERT INTO questions VALUES (null,'Elements in periodic table?','118','SCIENCE')");
        db.execSQL("INSERT INTO questions VALUES (null,'Vitamin in oranges?','vitamin c','SCIENCE')");
        db.execSQL("INSERT INTO questions VALUES (null,'Smallest bone?','stapes','SCIENCE')");
        db.execSQL("INSERT INTO questions VALUES (null,'Symbol for Iron?','fe','SCIENCE')");
        db.execSQL("INSERT INTO questions VALUES (null,'Study of fungi?','mycology','SCIENCE')");
        db.execSQL("INSERT INTO questions VALUES (null,'Organ filtering blood?','kidneys','SCIENCE')");
        db.execSQL("INSERT INTO questions VALUES (null,'Newton first law name?','inertia','SCIENCE')");
        db.execSQL("INSERT INTO questions VALUES (null,'Gas for balloons?','helium','SCIENCE')");
        db.execSQL("INSERT INTO questions VALUES (null,'Frozen water name?','ice','SCIENCE')");
        db.execSQL("INSERT INTO questions VALUES (null,'Molten rock underground?','magma','SCIENCE')");
        db.execSQL("INSERT INTO questions VALUES (null,'Main component of bones?','calcium','SCIENCE')");
        db.execSQL("INSERT INTO questions VALUES (null,'Process of liquid to solid?','freezing','SCIENCE')");
        db.execSQL("INSERT INTO questions VALUES (null,'Chemical symbol for Copper?','cu','SCIENCE')");
        db.execSQL("INSERT INTO questions VALUES (null,'Acid in vinegar?','acetic','SCIENCE')");
        db.execSQL("INSERT INTO questions VALUES (null,'Unit of electric current?','ampere','SCIENCE')");
        db.execSQL("INSERT INTO questions VALUES (null,'Planet rotating on side?','uranus','SCIENCE')");
        db.execSQL("INSERT INTO questions VALUES (null,'Smallest unit of matter?','atom','SCIENCE')");
        db.execSQL("INSERT INTO questions VALUES (null,'Device measuring radiation?','geiger counter','SCIENCE')");
        db.execSQL("INSERT INTO questions VALUES (null,'Mammal that lays eggs?','platypus','SCIENCE')");
        db.execSQL("INSERT INTO questions VALUES (null,'Study of snakes?','herpetology','SCIENCE')");
        db.execSQL("INSERT INTO questions VALUES (null,'Energy of motion?','kinetic','SCIENCE')");
        db.execSQL("INSERT INTO questions VALUES (null,'Symbol for Potassium?','k','SCIENCE')");
        db.execSQL("INSERT INTO questions VALUES (null,'Part of cell making protein?','ribosome','SCIENCE')");
        db.execSQL("INSERT INTO questions VALUES (null,'Gas causing global warming?','carbon dioxide','SCIENCE')");
        db.execSQL("INSERT INTO questions VALUES (null,'Study of the heart?','cardiology','SCIENCE')");
        db.execSQL("INSERT INTO questions VALUES (null,'Planet with Great Red Spot?','jupiter','SCIENCE')");
        db.execSQL("INSERT INTO questions VALUES (null,'Hardest part of human body?','enamel','SCIENCE')");
        db.execSQL("INSERT INTO questions VALUES (null,'Force opposing motion?','friction','SCIENCE')");
        db.execSQL("INSERT INTO questions VALUES (null,'Symbol for Lead?','pb','SCIENCE')");
        db.execSQL("INSERT INTO questions VALUES (null,'Study of birds?','ornithology','SCIENCE')");
        db.execSQL("INSERT INTO questions VALUES (null,'Process of gas to liquid?','condensation','SCIENCE')");
        db.execSQL("INSERT INTO questions VALUES (null,'Human body largest gland?','liver','SCIENCE')");
        db.execSQL("INSERT INTO questions VALUES (null,'Symbol for Sodium?','na','SCIENCE')");
        db.execSQL("INSERT INTO questions VALUES (null,'Study of fish?','ichthyology','SCIENCE')");
        db.execSQL("INSERT INTO questions VALUES (null,'Number of teeth in adult?','32','SCIENCE')");
        db.execSQL("INSERT INTO questions VALUES (null,'Main gas humans inhale?','oxygen','SCIENCE')");
        db.execSQL("INSERT INTO questions VALUES (null,'Vitamin for blood clotting?','vitamin k','SCIENCE')");
        db.execSQL("INSERT INTO questions VALUES (null,'Smallest blood vessel?','capillary','SCIENCE')");
        db.execSQL("INSERT INTO questions VALUES (null,'Symbol for Nitrogen?','n','SCIENCE')");
        db.execSQL("INSERT INTO questions VALUES (null,'Study of earthquakes?','seismology','SCIENCE')");
        db.execSQL("INSERT INTO questions VALUES (null,'Force between masses?','gravity','SCIENCE')");
        db.execSQL("INSERT INTO questions VALUES (null,'Chemical symbol for Carbon?','c','SCIENCE')");
        db.execSQL("INSERT INTO questions VALUES (null,'Main source of energy?','sun','SCIENCE')");

        // GENERAL KNOWLEDGE (100 Questions)
        db.execSQL("INSERT INTO questions VALUES (null,'Capital of Ethiopia?','addis ababa','GK')");
        db.execSQL("INSERT INTO questions VALUES (null,'Largest ocean?','pacific','GK')");
        db.execSQL("INSERT INTO questions VALUES (null,'Tallest mountain?','everest','GK')");
        db.execSQL("INSERT INTO questions VALUES (null,'Currency of Japan?','yen','GK')");
        db.execSQL("INSERT INTO questions VALUES (null,'Smallest country?','vatican city','GK')");
        db.execSQL("INSERT INTO questions VALUES (null,'Who painted Mona Lisa?','da vinci','GK')");
        db.execSQL("INSERT INTO questions VALUES (null,'Longest river?','nile','GK')");
        db.execSQL("INSERT INTO questions VALUES (null,'Capital of France?','paris','GK')");
        db.execSQL("INSERT INTO questions VALUES (null,'First man on moon?','neil armstrong','GK')");
        db.execSQL("INSERT INTO questions VALUES (null,'Largest desert?','sahara','GK')");
        db.execSQL("INSERT INTO questions VALUES (null,'Author of Hamlet?','shakespeare','GK')");
        db.execSQL("INSERT INTO questions VALUES (null,'Coldest continent?','antarctica','GK')");
        db.execSQL("INSERT INTO questions VALUES (null,'Most populous country?','india','GK')");
        db.execSQL("INSERT INTO questions VALUES (null,'Largest animal?','blue whale','GK')");
        db.execSQL("INSERT INTO questions VALUES (null,'Number of continents?','7','GK')");
        db.execSQL("INSERT INTO questions VALUES (null,'Capital of Italy?','rome','GK')");
        db.execSQL("INSERT INTO questions VALUES (null,'Deepest point in ocean?','mariana trench','GK')");
        db.execSQL("INSERT INTO questions VALUES (null,'Land of rising sun?','japan','GK')");
        db.execSQL("INSERT INTO questions VALUES (null,'Capital of Germany?','berlin','GK')");
        db.execSQL("INSERT INTO questions VALUES (null,'World War 2 ended?','1945','GK')");
        db.execSQL("INSERT INTO questions VALUES (null,'Largest island?','greenland','GK')");
        db.execSQL("INSERT INTO questions VALUES (null,'Capital of Canada?','ottawa','GK')");
        db.execSQL("INSERT INTO questions VALUES (null,'Smallest ocean?','arctic','GK')");
        db.execSQL("INSERT INTO questions VALUES (null,'Currency of UK?','pound','GK')");
        db.execSQL("INSERT INTO questions VALUES (null,'Capital of Australia?','canberra','GK')");
        db.execSQL("INSERT INTO questions VALUES (null,'Capital of Spain?','madrid','GK')");
        db.execSQL("INSERT INTO questions VALUES (null,'Capital of Russia?','moscow','GK')");
        db.execSQL("INSERT INTO questions VALUES (null,'Fastest land animal?','cheetah','GK')");
        db.execSQL("INSERT INTO questions VALUES (null,'Largest country by area?','russia','GK')");
        db.execSQL("INSERT INTO questions VALUES (null,'Capital of Brazil?','brasilia','GK')");
        db.execSQL("INSERT INTO questions VALUES (null,'Amount of players from a single football team32?','11','GK')");
        db.execSQL("INSERT INTO questions VALUES (null,'Capital of China?','beijing','GK')");
        db.execSQL("INSERT INTO questions VALUES (null,'Capital of Egypt?','cairo','GK')");
        db.execSQL("INSERT INTO questions VALUES (null,'Tallest building 2026?','burj khalifa','GK')");
        db.execSQL("INSERT INTO questions VALUES (null,'Home of Bollywood?','mumbai','GK')");
        db.execSQL("INSERT INTO questions VALUES (null,'Capital of Kenya?','nairobi','GK')");
        db.execSQL("INSERT INTO questions VALUES (null,'Author of Harry Potter?','jk rowling','GK')");
        db.execSQL("INSERT INTO questions VALUES (null,'Capital of USA?','washington dc','GK')");
        db.execSQL("INSERT INTO questions VALUES (null,'Longest wall?','great wall of china','GK')");
        db.execSQL("INSERT INTO questions VALUES (null,'Capital of India?','new delhi','GK')");
        db.execSQL("INSERT INTO questions VALUES (null,'National bird of India?','peacock','GK')");
        db.execSQL("INSERT INTO questions VALUES (null,'Host of 2024 Olympics?','paris','GK')");
        db.execSQL("INSERT INTO questions VALUES (null,'Largest rainforest?','amazon','GK')");
        db.execSQL("INSERT INTO questions VALUES (null,'Capital of Argentina?','buenos aires','GK')");
        db.execSQL("INSERT INTO questions VALUES (null,'Currency of South Korea?','won','GK')");
        db.execSQL("INSERT INTO questions VALUES (null,'Pink city name?','jaipur','GK')");
        db.execSQL("INSERT INTO questions VALUES (null,'Statue of Liberty location?','new york','GK')");
        db.execSQL("INSERT INTO questions VALUES (null,'Capital of Mexico?','mexico city','GK')");
        db.execSQL("INSERT INTO questions VALUES (null,'Number of states in USA?','50','GK')");
        db.execSQL("INSERT INTO questions VALUES (null,'Smallest state in India?','goa','GK')");
        db.execSQL("INSERT INTO questions VALUES (null,'Capital of Japan?','tokyo','GK')");
        db.execSQL("INSERT INTO questions VALUES (null,'National flower of Japan?','cherry blossom','GK')");
        db.execSQL("INSERT INTO questions VALUES (null,'Big Apple city?','new york','GK')");
        db.execSQL("INSERT INTO questions VALUES (null,'Capital of Thailand?','bangkok','GK')");
        db.execSQL("INSERT INTO questions VALUES (null,'City of canals?','venice','GK')");
        db.execSQL("INSERT INTO questions VALUES (null,'Capital of Greece?','athens','GK')");
        db.execSQL("INSERT INTO questions VALUES (null,'National animal of India?','tiger','GK')");
        db.execSQL("INSERT INTO questions VALUES (null,'Capital of South Africa?','pretoria','GK')");
        db.execSQL("INSERT INTO questions VALUES (null,'Capital of Norway?','oslo','GK')");
        db.execSQL("INSERT INTO questions VALUES (null,'Colors in rainbow?','7','GK')");
        db.execSQL("INSERT INTO questions VALUES (null,'Capital of Turkey?','ankara','GK')");
        db.execSQL("INSERT INTO questions VALUES (null,'Currency of Europe?','euro','GK')");
        db.execSQL("INSERT INTO questions VALUES (null,'Capital of Portugal?','lisbon','GK')");
        db.execSQL("INSERT INTO questions VALUES (null,'Ship that sank 1912?','titanic','GK')");
        db.execSQL("INSERT INTO questions VALUES (null,'Capital of Sweden?','stockholm','GK')");
        db.execSQL("INSERT INTO questions VALUES (null,'King of the jungle?','lion','GK')");
        db.execSQL("INSERT INTO questions VALUES (null,'Capital of Saudi Arabia?','riyadh','GK')");
        db.execSQL("INSERT INTO questions VALUES (null,'Largest lake?','caspian sea','GK')");
        db.execSQL("INSERT INTO questions VALUES (null,'Capital of Pakistan?','islamabad','GK')");
        db.execSQL("INSERT INTO questions VALUES (null,'Author of 1984?','george orwell','GK')");
        db.execSQL("INSERT INTO questions VALUES (null,'Capital of Indonesia?','nusantara','GK')");
        db.execSQL("INSERT INTO questions VALUES (null,'Host of 2026 FIFA World Cup?','usa canada mexico','GK')");
        db.execSQL("INSERT INTO questions VALUES (null,'Capital of Iraq?','baghdad','GK')");
        db.execSQL("INSERT INTO questions VALUES (null,'Capital of Switzerland?','bern','GK')");
        db.execSQL("INSERT INTO questions VALUES (null,'Number of keys on piano?','88','GK')");
        db.execSQL("INSERT INTO questions VALUES (null,'Capital of Iran?','tehran','GK')");
        db.execSQL("INSERT INTO questions VALUES (null,'Capital of Cuba?','havana','GK')");
        db.execSQL("INSERT INTO questions VALUES (null,'World largest democracy?','india','GK')");
        db.execSQL("INSERT INTO questions VALUES (null,'Capital of Finland?','helsinki','GK')");
        db.execSQL("INSERT INTO questions VALUES (null,'Capital of Peru?','lima','GK')");
        db.execSQL("INSERT INTO questions VALUES (null,'Smallest planet name?','mercury','GK')");
        db.execSQL("INSERT INTO questions VALUES (null,'Capital of Belgium?','brussels','GK')");
        db.execSQL("INSERT INTO questions VALUES (null,'Capital of Chile?','santiago','GK')");
        db.execSQL("INSERT INTO questions VALUES (null,'Symbol of peace?','dove','GK')");
        db.execSQL("INSERT INTO questions VALUES (null,'Capital of Austria?','vienna','GK')");
        db.execSQL("INSERT INTO questions VALUES (null,'Capital of Malaysia?','kuala lumpur','GK')");
        db.execSQL("INSERT INTO questions VALUES (null,'Island country of kangaroos?','australia','GK')");
        db.execSQL("INSERT INTO questions VALUES (null,'Capital of Vietnam?','hanoi','GK')");
        db.execSQL("INSERT INTO questions VALUES (null,'Capital of Ireland?','dublin','GK')");
        db.execSQL("INSERT INTO questions VALUES (null,'Fastest bird?','peregrine falcon','GK')");
        db.execSQL("INSERT INTO questions VALUES (null,'Capital of Netherlands?','amsterdam','GK')");
        db.execSQL("INSERT INTO questions VALUES (null,'Capital of Colombia?','bogota','GK')");
        db.execSQL("INSERT INTO questions VALUES (null,'World oldest civilization?','mesopotamia','GK')");
        db.execSQL("INSERT INTO questions VALUES (null,'Capital of Poland?','warsaw','GK')");
        db.execSQL("INSERT INTO questions VALUES (null,'Capital of New Zealand?','wellington','GK')");
        db.execSQL("INSERT INTO questions VALUES (null,'Largest bay?','bay of bengal','GK')");
        db.execSQL("INSERT INTO questions VALUES (null,'Capital of Singapore?','singapore','GK')");
        db.execSQL("INSERT INTO questions VALUES (null,'Capital of Israel?','jerusalem','GK')");
        db.execSQL("INSERT INTO questions VALUES (null,'Longest day in North?','june 21','GK')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldV, int newV) {
        db.execSQL("DROP TABLE IF EXISTS users");
        db.execSQL("DROP TABLE IF EXISTS questions");
        db.execSQL("DROP TABLE IF EXISTS results");
        onCreate(db);
    }
}

