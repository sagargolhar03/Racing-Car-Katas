package tddmicroexercises.telemetrysystem;

public class TelementryDiagnosticControlsImpl implements TelemetryDiagnosticInterface {


    private final TelemetryClient telemetryClient;


    public TelementryDiagnosticControlsImpl() {
        this.telemetryClient = new TelemetryClient();
        ;
    }

    @Override
    public TelemetryClient getTelemetryClient() {
        return telemetryClient;
    }

    @Override
    public void connect(String msg) {
        telemetryClient.connect(msg);
    }

    @Override
    public void disconnect() {
        telemetryClient.disconnect();
    }

}
