import java.util.ArrayList;


public class Gamer {
    String name = "";
    String firstHit = "";
    boolean win = false;
    public String winner = "YOU WIN!WIN!WIN!";

    int caseTry = 0;
    int[] fieldGamer;
    int[] fieldEnemy = new int[100];
    String[] letter = new String[]{"а", "б", "в", "г", "д", "е", "ж", "з", "и", "к"};
    ArrayList<Ship> listShips = new ArrayList<Ship>();
    ArrayList<String> tryOuts = new ArrayList<String>();
    ArrayList<String> successTry = new ArrayList<String>();
    ArrayList<String> namesOfallField = new ArrayList<String>();
    Ship ship1 = new Ship.oneKindShip();
    Ship ship2 = new Ship.oneKindShip();
    Ship ship3 = new Ship.oneKindShip();
    Ship ship4 = new Ship.oneKindShip();
    Ship ship5 = new Ship.twoKindShip();
    Ship ship6 = new Ship.twoKindShip();
    Ship ship7 = new Ship.twoKindShip();
    Ship ship8 = new Ship.threeKindShip();
    Ship ship9 = new Ship.threeKindShip();
    Ship ship10 = new Ship.fourKindShip();


    Ocean start = new Ocean();

    public Gamer() {
    }


    public void tryScope(Gamer gamer0, GameFrame gf) {
    }


    public String fromIntToString(int scope) {
        String row = letter[(scope % 10)];
        int temp = (scope / 10) + 1;
        return row.concat(Integer.toString(temp));
    }

    public void setLoc(Ship ship, Gamer gamer0) {
        ArrayList<String> notToShoot = new ArrayList<String>();
        int ticr = 0;
        if (ship.locListCopy.size() > 1) {
            if (Math.abs(toInt(ship.locListCopy.get(0)) - toInt(ship.locListCopy.get(1))) == 10) {
                ticr = 1;
            } else if (Math.abs(toInt(ship.locListCopy.get(0)) - toInt(ship.locListCopy.get(1))) == 1) {
                ticr = 2;
            }
        } else {
            ticr = 3;
        }
        for (int i = 0; i < ship.locListCopy.size(); i++) {
            int temp = toInt(ship.locListCopy.get(i));


            if (ticr == 1) {
                if ((temp + 1) / 10 == temp / 10) {
                    if (gamer0.fieldGamer[temp + 1] == 0) {
                        gamer0.fieldGamer[temp + 1] = 4;
                    }
                }
                if ((temp - 1) / 10 == temp / 10 && temp - 1 >= 0) {
                    if (gamer0.fieldGamer[temp - 1] == 0) {
                        gamer0.fieldGamer[temp - 1] = 4;
                    }
                }
                if (i == 0) {
                    if (temp - 10 >= 0) {
                        if (gamer0.fieldGamer[temp - 10] == 0) {
                            gamer0.fieldGamer[temp - 10] = 4;
                        }

                        if (temp - 10 - 1 >= 0 && (temp - 10 - 1) / 10 == (temp - 10) / 10) {
                            if (gamer0.fieldGamer[temp - 10 - 1] == 0) {
                                gamer0.fieldGamer[temp - 10 - 1] = 4;
                            }
                        }
                        if ((temp - 10 + 1) / 10 == (temp - 10) / 10) {
                            if (gamer0.fieldGamer[temp - 10 + 1] == 0) {
                                gamer0.fieldGamer[temp - 10 + 1] = 4;
                            }
                        }
                    }
                }
                if (i == ship.locListCopy.size() - 1) {
                    if (temp + 10 < 100) {
                        if (gamer0.fieldGamer[temp + 10] == 0) {
                            gamer0.fieldGamer[temp + 10] = 4;
                        }

                        if (temp + 10 + 1 < 100 && (temp + 10 + 1) / 10 == (temp + 10) / 10) {
                            if (gamer0.fieldGamer[temp + 10 + 1] == 0) {
                                gamer0.fieldGamer[temp + 10 + 1] = 4;
                            }
                        }
                        if ((temp + 10 - 1) / 10 == (temp + 10) / 10) {
                            if (gamer0.fieldGamer[temp + 10 - 1] == 0) {
                                gamer0.fieldGamer[temp + 10 - 1] = 4;
                            }
                        }
                    }
                }
            } else if (ticr == 2) {
                if (temp + 10 < 100) {
                    if (gamer0.fieldGamer[temp + 10] == 0) {
                        gamer0.fieldGamer[temp + 10] = 4;
                    }
                }
                if (temp - 10 >= 0) {
                    if (gamer0.fieldGamer[temp - 10] == 0) {
                        gamer0.fieldGamer[temp - 10] = 4;
                    }
                }
                if (i == 0) {
                    if ((temp - 1) / 10 == temp / 10 && temp - 1 >= 0) {
                        if (gamer0.fieldGamer[temp - 1] == 0) {
                            gamer0.fieldGamer[temp - 1] = 4;
                        }
                        if (temp - 1 - 10 >= 0) {
                            if (gamer0.fieldGamer[temp - 1 - 10] == 0) {
                                gamer0.fieldGamer[temp - 1 - 10] = 4;
                            }
                        }
                        if (temp - 1 + 10 < 100) {
                            if (gamer0.fieldGamer[temp - 1 + 10] == 0) {
                                gamer0.fieldGamer[temp - 1 + 10] = 4;
                            }
                        }
                    }
                }
                if (i == ship.locListCopy.size() - 1) {
                    if ((temp + 1) / 10 == temp / 10 && temp + 1 < 100) {
                        if (gamer0.fieldGamer[temp + 1] == 0) {
                            gamer0.fieldGamer[temp + 1] = 4;
                        }

                        if (temp + 1 - 10 >= 0) {
                            if (gamer0.fieldGamer[temp + 1 - 10] == 0) {
                                gamer0.fieldGamer[temp + 1 - 10] = 4;
                            }
                        }
                        if (temp + 1 + 10 < 100) {
                            if (gamer0.fieldGamer[temp + 1 + 10] == 0) {
                                gamer0.fieldGamer[temp + 1 + 10] = 4;
                            }
                        }
                    }
                }
            } else {
                if (temp + 10 < 100) {
                    if (gamer0.fieldGamer[temp + 10] == 0) {
                        gamer0.fieldGamer[temp + 10] = 4;
                    }
                }
                if (temp - 10 >= 0) {
                    if (gamer0.fieldGamer[temp - 10] == 0) {
                        gamer0.fieldGamer[temp - 10] = 4;
                    }
                }
                if ((temp + 1) / 10 == temp / 10 && temp + 1 < 100) {
                    if (gamer0.fieldGamer[temp + 1] == 0) {
                        gamer0.fieldGamer[temp + 1] = 4;
                    }

                    if (temp + 1 - 10 >= 0) {
                        if (gamer0.fieldGamer[temp + 1 - 10] == 0) {
                            gamer0.fieldGamer[temp + 1 - 10] = 4;
                        }
                    }
                    if (temp + 1 + 10 < 100) {
                        if (gamer0.fieldGamer[temp + 1 + 10] == 0) {
                            gamer0.fieldGamer[temp + 1 + 10] = 4;
                        }
                    }
                }
                if ((temp - 1) / 10 == temp / 10 && temp - 1 >= 0) {
                    if (gamer0.fieldGamer[temp - 1] == 0) {
                        gamer0.fieldGamer[temp - 1] = 4;
                    }

                    if (temp - 1 - 10 >= 0) {
                        if (gamer0.fieldGamer[temp - 1 - 10] == 0) {
                            gamer0.fieldGamer[temp - 1 - 10] = 4;
                        }
                    }
                    if (temp - 1 + 10 < 100) {
                        if (gamer0.fieldGamer[temp - 1 + 10] == 0) {
                            gamer0.fieldGamer[temp - 1 + 10] = 4;
                        }
                    }
                }
            }

        }
        for (int i = 0; i < gamer0.fieldGamer.length; i++) {
            if (gamer0.fieldGamer[i] == 4) {
                notToShoot.add(fromIntToString(i));
            }
        }
        namesOfallField.removeAll(notToShoot);
    }


    public int checkScope(String s, Gamer gamer0) {
        int p = 0;
        int temp = toInt(s);

        if (gamer0.start.allCoords.indexOf(s) >= 0) {
            for (Ship ship : gamer0.listShips) {
                if (ship.locList.indexOf(s) >= 0) {
                    ship.locList.remove(s);
                    gamer0.start.allCoords.remove(s);
                    namesOfallField.remove(s);
                    //System.out.println(s);
                    //System.out.println("Success attack!");
                    p = 1;


                    if (ship.locList.isEmpty()) {
                        //System.out.println("ShipDown!!!!");
                        setLoc(ship, gamer0);
                        gamer0.listShips.remove(ship);
                        firstHit = "";
                        p = 2;
                    }
                    if (gamer0.start.allCoords.isEmpty()) {
                        win = true;
                        System.out.println(winner);
                    }
                    break;
                }
            }
            fieldEnemy[temp] = 1;
            gamer0.fieldGamer[temp] = 3;
        } else {
            //System.out.println(s);
            //System.out.println("Pfff unluck.");
            fieldEnemy[temp] = 2;
            gamer0.fieldGamer[temp] = 2;
            namesOfallField.remove(s);
            p = 0;

        }
        tryOuts.add(0, s);

        return p;
    }

    public int toInt(String s) {

        String res = null;
        int j = 0;
        for (int i = 0; i < letter.length; i++) {
            if (s.contains(letter[i])) {
                res = Integer.toString(i);
            }
            if (s.contains(Integer.toString(i + 1))) {
                j = i;
            }
        }

        res = Integer.toString(j) + res;

        return Integer.parseInt(res);
    }

    public void placeAllShips() {
        listShips.add(ship10);
        listShips.add(ship9);
        listShips.add(ship8);
        listShips.add(ship7);
        listShips.add(ship6);
        listShips.add(ship5);
        listShips.add(ship4);
        listShips.add(ship3);
        listShips.add(ship2);
        listShips.add(ship1);

        for (Ship ship : listShips) {
            ship.locList.addAll(start.placeShip(ship));
            /*start.printLikeTable(start.field);
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            try {
                reader.readLine();
            }
            catch (IOException e) {
                e.printStackTrace();
            }*/
        }
        fieldGamer = start.field.clone();
        //start.printLikeTable(start.field);
        //start.printLikeTable(fieldGamer);
    }

    public void gamerStart() {
        placeAllShips();

        for (int i = 0; i < fieldGamer.length; i++) {
            if (fieldGamer[i] == 2) {
                fieldGamer[i] = 0;
            }
        }
    }
}
