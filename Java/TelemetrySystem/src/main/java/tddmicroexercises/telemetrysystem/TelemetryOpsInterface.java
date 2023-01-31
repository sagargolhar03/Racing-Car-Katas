package tddmicroexercises.telemetrysystem;

public interface TelemetryOpsInterface {

    void checkTransmission() throws Exception;

    Object getDiagnosticInfo();
}
