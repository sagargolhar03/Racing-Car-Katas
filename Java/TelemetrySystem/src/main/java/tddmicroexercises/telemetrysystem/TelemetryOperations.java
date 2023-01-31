package tddmicroexercises.telemetrysystem;

public class TelemetryOperations implements Operations {


    private final String DiagnosticChannelConnectionString = "*111#";

    DiagnosticControls telemetryDiagnostic = new TelementryDiagnosticControlss();
    private String diagnosticInfo = "";


    @Override
    public void checkTransmission() throws Exception {
        diagnosticInfo = "";

        telemetryDiagnostic.disconnect();

        int retryLeft = 3;
        while (telemetryDiagnostic.getTelemetryClient().getOnlineStatus() == false && retryLeft > 0) {
            telemetryDiagnostic.connect(DiagnosticChannelConnectionString);
            retryLeft -= 1;
        }

        if (telemetryDiagnostic.getTelemetryClient().getOnlineStatus() == false) {
            throw new Exception("Unable to connect.");
        }

        telemetryDiagnostic.getTelemetryClient().send(TelemetryClient.DIAGNOSTIC_MESSAGE);
        diagnosticInfo = telemetryDiagnostic.getTelemetryClient().receive();
    }

    @Override
    public Object getDiagnosticInfo() {
        return diagnosticInfo;
    }

    public void setDiagnosticInfo(String diagnosticInfo) {
        this.diagnosticInfo = diagnosticInfo;
    }
}
