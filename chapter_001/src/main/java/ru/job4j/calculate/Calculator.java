package ru.job4j.calculate;

    /**
    * Class Calculator 3.1. Элементарный калькулятор.[#91029].
    * @author Ayder Khayredinov (emage.haf@gmail.com)
    * @since 01.12.2018
    * @version 1
    */
    public class Calculator {

        /**
        * поле результата выражения.
        */
        private double result;

        /**
         * Method add - сложение.
        * @param first - первый аргумент выражения.
        * @param second - второй аргумент выражения.
        */
        public void add(double first, double second) {
            this.result = first + second;
        }

        /**
         * Method substract - вычитание.
         * @param first - первый аргумент выражения.
         * @param second - второй аргумент выражения.
         */
        public void substract(double first, double second) {
            this.result = first - second;
        }

        /**
         * Method div - деление.
         * @param first - первый аргумент выражения.
         * @param second - второй аргумент выражения.
         */
        public void div(double first, double second) {
            this.result = first / second;
        }

        /**
         * Method multiple - умножение.
         * @param first - первый аргумент выражения.
         * @param second - второй аргумент выражения.
         */
        public void multiple(double first, double second) {
            this.result = first * second;
        }

        /**
         * Method getResult - получение результата.
         * @return результат.
         */
        public double getResult() {
            return this.result;
        }
    }