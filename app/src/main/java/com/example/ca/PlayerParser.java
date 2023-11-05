package com.example.ca;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.util.Log;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PlayerParser {
    private Context context;

    public PlayerParser(Context context) {
        this.context = context;
    }

    public List<Player> getPlayers() {
        List<Player> playerList = new ArrayList<>();

        try {
            Resources res = context.getResources();
            XmlResourceParser parser = res.getXml(R.xml.players);

            String playerName = null;
            String playerPosition = null;
            String playerImage = null;
            String playerAppearances = null;
            String playerGoals = null;
            String playerAssists = null;
            String playerBio = null;
            String playerUrl = null;

            while (parser.getEventType() != XmlPullParser.END_DOCUMENT) {
                if(parser.getEventType() == XmlPullParser.START_TAG) {
                    String tagName = parser.getName();
                    if("Player".equals(tagName)) {
                        while (parser.next() != XmlPullParser.END_TAG) {
                                tagName = parser.getName();
                                if ("name".equals(tagName)) {
                                    playerName = parser.nextText();
                                } else if ("position".equals(tagName)) {
                                    playerPosition = parser.nextText();
                                } else if ("image".equals(tagName)) {
                                    playerImage = parser.nextText();
                                } else if ("appearances".equals(tagName)) {
                                    playerAppearances = parser.nextText();
                                } else if ("goals".equals(tagName)) {
                                    playerGoals = parser.nextText();
                                } else if ("assists".equals(tagName)) {
                                    playerAssists = parser.nextText();
                                } else if ("bio".equals(tagName)) {
                                    playerBio = parser.nextText();
                                } else if ("url".equals(tagName)) {
                                    playerUrl = parser.nextText();
                                }
                        }
                        // Create a Player object and add it to the list
                        Player player = new Player(playerName, playerPosition, playerImage,
                                playerAppearances, playerGoals, playerAssists, playerBio, playerUrl);
                        playerList.add(player);
                    }
                }

                parser.next();
            }
        } catch (XmlPullParserException | IOException e) {
            e.printStackTrace();
        }
        return playerList;
    }
}