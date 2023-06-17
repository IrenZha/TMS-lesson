public enum Position {
    DIRECTOR,
    ENGINEER;

    public enum TypeOfPosition {
        GENERAL(Position.DIRECTOR, 800),
        DEPARTMENT(Position.DIRECTOR, 600),
        AUTOMATOR(Position.ENGINEER, 400),
        ROBOTICS(Position.ENGINEER, 450),
        COMMUNICATION(Position.ENGINEER, 500);

        private final double positionCoefficient;
        private final Position position;

        TypeOfPosition(Position position, double positionCoefficient) {
            this.positionCoefficient = positionCoefficient;
            this.position = position;
        }

        public double getPositionCoefficient() {
            return positionCoefficient;
        }

        public String getPosition() {
            return position.name();
        }
    }

}
