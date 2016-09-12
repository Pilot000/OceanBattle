import java.util.ArrayList;


public class Ocean {
    int length = 10;
    int size = 100;
    int[] field = new int[size];
    int[] coords;
    int[] incr = new int[]{10, -10, 1, -1};
    int nicr = 0;
    String[] letter = new String[]{"а", "б", "в", "г", "д", "е", "ж", "з", "и", "к"};
    ArrayList<String> allCoords = new ArrayList<String>();

    public ArrayList<String> placeShip(Ship ship) {
        int shots = ship.shots;
        ArrayList<String> shipIn = new ArrayList<String>();
        coords = new int[shots];
        int shots0 = shots;

        while (shots0 > 0) {
            int x = 0;
            shots0 = shots;
            int location = (int) (Math.random() * size);

            if (field[location] == 0) {
                nicr = (int) (Math.random() * 4);

                {
                    switch (nicr) {
                        case 0:
                            nicr = 0;
                            if (location + incr[nicr] * shots < 100) {
                                while (shots0 > 0) {
                                    if (field[location] == 0) {
                                        coords[x] = location;
                                        location += incr[nicr];
                                        shots0--;
                                        x++;
                                    } else {
                                        break;
                                    }
                                }
                                if (shots0 == 0) {
                                    break;
                                }
                            } else {
                                continue;
                            }
                        case 1:
                            nicr = 1;
                            if (location + incr[nicr] * shots >= 0) {
                                while (shots0 > 0) {
                                    if (field[location] == 0) {
                                        coords[x] = location;
                                        location += incr[nicr];
                                        shots0--;
                                        x++;
                                    } else {
                                        break;
                                    }
                                }
                                if (shots0 == 0) {
                                    break;
                                }
                            } else {
                                continue;
                            }
                        case 2:
                            nicr = 2;
                            if ((location + incr[nicr] * shots) / length == location / length) {
                                while (shots0 > 0) {
                                    if (field[location] == 0) {
                                        coords[x] = location;
                                        location += incr[nicr];
                                        shots0--;
                                        x++;
                                    } else {
                                        break;
                                    }
                                }
                                if (shots0 == 0) {
                                    break;
                                }
                            } else {
                                continue;
                            }
                        case 3:
                            nicr = 3;
                            if ((location + incr[nicr] * shots) / length == location / length && (location + incr[nicr] * shots) >= 0) {
                                while (shots0 > 0) {
                                    if (field[location] == 0) {
                                        coords[x] = location;
                                        location += incr[nicr];
                                        shots0--;
                                        x++;
                                    } else {
                                        break;
                                    }
                                }
                                if (shots0 == 0) {
                                    break;
                                }
                            } else {
                                break;
                            }

                    }// заканчивается switch
                }

            } // проверочный вход


        }// заканчивается основной цикл

        //print(coords);
        minToMaxValue(coords);

        setFieldLoc();
        //printLikeTable(field);


        for (int i = 0; i < coords.length; i++) {
            String row = letter[(coords[i] % length)];
            int temp = (coords[i] / length) + 1;
            shipIn.add(row.concat(Integer.toString(temp)));
        }
        allCoords.addAll(shipIn);
        ship.locListCopy.addAll(shipIn);
        return shipIn;
    }

    // размещаем корабль на игровом поле
    //


    public void setFieldLoc() {
        for (int i = 0; i < coords.length; i++) {
            field[coords[i]] = 1;
            if (incr[nicr] == 10 || incr[nicr] == -10) {
                if ((coords[i] + 1) / length == coords[i] / length) {
                    field[coords[i] + 1] = 2;
                }
                if ((coords[i] - 1) / length == coords[i] / length && coords[i] - 1 >= 0) {
                    field[coords[i] - 1] = 2;
                }

                if (i == 0) {
                    if (coords[i] - 10 >= 0) {
                        field[coords[i] - 10] = 2;

                        if (coords[i] - 10 - 1 >= 0 && (coords[i] - 10 - 1) / length == (coords[i] - 10) / length) {
                            field[coords[i] - 10 - 1] = 2;
                        }
                        if ((coords[i] - 10 + 1) / length == (coords[i] - 10) / length) {
                            field[coords[i] - 10 + 1] = 2;
                        }
                    }

                }

                if (i == coords.length - 1) {
                    if (coords[i] + 10 < 100) {
                        field[coords[i] + 10] = 2;

                        if (coords[i] + 10 + 1 < 100 && (coords[i] + 10 + 1) / length == (coords[i] + 10) / length) {
                            field[coords[i] + 10 + 1] = 2;
                        }
                        if ((coords[i] + 10 - 1) / length == (coords[i] + 10) / length) {
                            field[coords[i] + 10 - 1] = 2;
                        }
                    }

                }

            } else if (incr[nicr] == 1 || incr[nicr] == -1) {
                if (coords[i] + 10 < 100) {
                    field[coords[i] + 10] = 2;
                }
                if (coords[i] - 10 >= 0) {
                    field[coords[i] - 10] = 2;
                }

                if (i == 0) {
                    if ((coords[i] - 1) / length == coords[i] / length && coords[i] - 1 >= 0) {
                        field[coords[i] - 1] = 2;

                        if (coords[i] - 1 - 10 >= 0) {
                            field[coords[i] - 1 - 10] = 2;
                        }
                        if (coords[i] - 1 + 10 < 100) {
                            field[coords[i] - 1 + 10] = 2;
                        }
                    }
                }
                if (i == coords.length - 1) {
                    if ((coords[i] + 1) / length == coords[i] / length && coords[i] + 1 < 100) {
                        field[coords[i] + 1] = 2;

                        if (coords[i] + 1 - 10 >= 0) {
                            field[coords[i] + 1 - 10] = 2;
                        }
                        if (coords[i] + 1 + 10 < 100) {
                            field[coords[i] + 1 + 10] = 2;
                        }
                    }
                }
            }


        }
    }

    public int[] minToMaxValue(int[] coords) {
        for (int j = 0; j < coords.length; j++) {
            for (int z = j; z < coords.length; z++) {
                if (coords[j] > coords[z]) {
                    int u = coords[j];
                    coords[j] = coords[z];
                    coords[z] = u;
                }
            }
        }
        return coords;
    }

    public void print(int[] coords) {
        for (int j : coords) {
            System.out.print(j + " ");
        }
        System.out.println();
    }

    public void printLikeTable(int[] field) {
        System.out.println("   а б в г д е ж з и к");

        for (int j = 0; j < field.length; j += length) {
            if ((j / length) + 1 < 10) {
                System.out.print((j / length) + 1 + " |");
            } else {
                System.out.print((j / length) + 1 + "|");
            }
            for (int z = j; z < j + length; z++) {
                if (field[z] == 1) {
                    System.out.print("X ");
                } else if (field[z] == 2) {
                    System.out.print("* ");
                } else {
                    System.out.print("o ");
                }
            }
            System.out.println();
        }
    }
}
