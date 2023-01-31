package tddmicroexercises.telemetrysystem;

public class TelementryDiagnosticControlsImpl implements TelemetryDiagnosticInterface, TelemetryOpsInterface {

    private final String DiagnosticChannelConnectionString = "*111#";

    private final TelemetryClient telemetryClient;
    private String diagnosticInfo = "";

    public TelementryDiagnosticControlsImpl() {
        this.telemetryClient = new TelemetryClient();;
    }

    @Override
    public String getDiagnosticInfo() {
        return diagnosticInfo;
    }

    public void setDiagnosticInfo(String diagnosticInfo) {
        this.diagnosticInfo = diagnosticInfo;
    }

    @Override
    public void connect(String msg) {
        telemetryClient.connect(msg);
    }

    @Override
    public void disconnect() {
        telemetryClient.disconnect();
    }


    @Override
    public void checkTransmission() throws Exception {
        diagnosticInfo = "";

        disconnect();

        int retryLeft = 3;
        while (telemetryClient.getOnlineStatus() == false && retryLeft > 0) {
            connect(DiagnosticChannelConnectionString);
            retryLeft -= 1;
        }

        if (telemetryClient.getOnlineStatus() == false) {
            throw new Exception("Unable to connect.");
        }

        telemetryClient.send(TelemetryClient.DIAGNOSTIC_MESSAGE);
        diagnosticInfo = telemetryClient.receive();
    }
}
