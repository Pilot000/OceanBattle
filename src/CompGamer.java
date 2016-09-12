public class CompGamer extends Gamer {
    int coumtComp = 0;
    //String firstHit = ""; // закрепление места первого попадания
    int positShip = 0; // положение корабля 1-вертикально, 2-горизонтально
    int ticr = -1;


    CompGamer() {
        coumtComp++;
        name = "Comp" + coumtComp;
        winner = "Computer wins!!!! " + name;
        for (int i = 0; i < 100; i++) {
            namesOfallField.add(fromIntToString(i));
        }
    }


    public void tryScope(Gamer gamer0, GameFrame gf) {
        String set;
        int nicr = 0;
        int noneFit = 1; // для цикличности и перебора если не подойдет 3 из 4  case в switch(при заполненности клеток рядом и поиска одной верной)
        int[] incr = new int[]{10, -10, 1, -1};
        {
            if (!win) {
                if ((caseTry == 0 && firstHit.equals("")) || caseTry == 2) {
                    while (true) {
                        int scope = (int) (Math.random() * namesOfallField.size());
                        set = namesOfallField.get(scope);
                        if (tryOuts.indexOf(set) < 0) {
                            tryOuts.add(0, set);
                            break;
                        }
                    }
                    caseTry = checkScope(set, gamer0);
                    gf.defenseTable();
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    positShip = 0;
                    if (caseTry == 1) {
                        firstHit = set;
                    }
                    if (caseTry > 0) {
                        successTry.add(0, set);
                        tryScope(gamer0, gf);
                    }
                } else if (caseTry == 1 || (caseTry == 0 && !firstHit.equals(""))) {  // начало алгоритма уничтожения кораблей
                    int location = toInt(successTry.get(0));
                    if (positShip == 0) {
                        nicr = (int) (Math.random() * 4);
                        if (noneFit > 1) {
                            nicr = 0;
                        }
                    } else if (positShip == 1) {
                        nicr = ticr;
                        if (location + incr[nicr] < 0 || location + incr[nicr] > 100) {
                            nicr = ticr == 0 ? nicr + 1 : nicr - 1; // если пред раз промазали и/или клетка занята
                            location = toInt(firstHit);
                        } else if (fieldEnemy[location + incr[nicr]] != 0) {
                            nicr = ticr == 0 ? nicr + 1 : nicr - 1; // если пред раз промазали и/или клетка занята
                            location = toInt(firstHit);
                        }
                    } else if (positShip == 2) {
                        nicr = ticr;
                        if ((location + incr[nicr]) < 0 || (location + incr[nicr]) / 10 != location / 10 || fieldEnemy[location + incr[nicr]] != 0) {
                            nicr = ticr == 2 ? nicr + 1 : nicr - 1;
                            location = toInt(firstHit);
                        }
                    }
                    switch (nicr) {
                        case 0:
                            nicr = 0;
                            if (location + incr[nicr] < 100 && fieldEnemy[location + incr[nicr]] == 0) {
                                noneFit = 0;
                                location += incr[nicr];
                                set = fromIntToString(location);
                                caseTry = checkScope(set, gamer0);
                                gf.defenseTable();
                                try {
                                    Thread.sleep(500);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                                ticr = nicr;
                                if (caseTry > 0) {
                                    successTry.add(0, set);
                                    positShip = 1;
                                    tryScope(gamer0, gf);
                                }
                                break;
                            }
                        case 1:
                            nicr = 1;
                            if (location + incr[nicr] >= 0 && fieldEnemy[location + incr[nicr]] == 0) {
                                noneFit = 0;
                                location += incr[nicr];
                                set = fromIntToString(location);
                                caseTry = checkScope(set, gamer0);
                                gf.defenseTable();
                                try {
                                    Thread.sleep(500);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                                ticr = nicr;
                                if (caseTry > 0) {
                                    successTry.add(0, set);
                                    positShip = 1;
                                    tryScope(gamer0, gf);
                                }
                                break;
                            }

                        case 2:
                            nicr = 2;
                            if ((location + incr[nicr]) / 10 == location / 10 && fieldEnemy[location + incr[nicr]] == 0) {
                                noneFit = 0;
                                location += incr[nicr];
                                set = fromIntToString(location);
                                caseTry = checkScope(set, gamer0);
                                gf.defenseTable();
                                try {
                                    Thread.sleep(500);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                                ticr = nicr;
                                if (caseTry > 0) {
                                    successTry.add(0, set);
                                    positShip = 2;
                                    tryScope(gamer0, gf);
                                }
                                break;
                            }

                        case 3:
                            nicr = 3;
                            if ((location + incr[nicr]) / 10 == location / 10 && (location + incr[nicr]) >= 0 && fieldEnemy[location + incr[nicr]] == 0) {
                                noneFit = 0;
                                location += incr[nicr];
                                set = fromIntToString(location);
                                caseTry = checkScope(set, gamer0);
                                gf.defenseTable();
                                try {
                                    Thread.sleep(500);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                                ticr = nicr;
                                if (caseTry > 0) {
                                    successTry.add(0, set);
                                    positShip = 2;
                                    tryScope(gamer0, gf);
                                }
                                break;
                            }

                        default:
                            noneFit++;
                            if (noneFit > 0) {
                                ticr = 0;
                                tryScope(gamer0, gf);
                            }
                    }
                }
            }
        }

    }


}
