package org.firstinspires.ftc.robotcontroller;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import static java.lang.Math.abs;

@com.qualcomm.robotcore.eventloop.opmode.TeleOp(name= "Strafer Kit")
public class TeleOp extends OpMode {

    DcMotor lf;
    DcMotor lb;
    DcMotor rf;
    DcMotor rb;

    @Override
    public void init() {
        lf = hardwareMap.get(DcMotor.class, "lf");
        lb = hardwareMap.get(DcMotor.class, "lb");
        rf = hardwareMap.get(DcMotor.class, "rf");
        rb = hardwareMap.get(DcMotor.class, "rb");
        telemetry.addData("initialization", "Ready");
    }

    @Override
    public void loop() {
        double y = gamepad1.left_stick_y;
        double x = gamepad1.left_stick_x;
        double rx = gamepad1.right_stick_x;
        double lfPower = y + x + rx;
        double lbPower = y - x + rx;
        double rfPower =-y + x + rx;
        double rbPower =-y - x + rx;
        double denominator = Math.max(abs(y) + abs(x) + abs(rx), 1.0);
        lf.setPower(lfPower/denominator);
        lb.setPower(lbPower/denominator);
        rf.setPower(rfPower/denominator);
        rb.setPower(rbPower/denominator);
        telemetry.addData("lfPower", lfPower/denominator);
        telemetry.addData("lfPower", lbPower/denominator);
        telemetry.addData("lfPower", rfPower/denominator);
        telemetry.addData("lfPower", rbPower/denominator);
        telemetry.update();

    }
}
