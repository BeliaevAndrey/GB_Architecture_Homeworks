package models;

import Excptions.TicketPurchasedException;

import java.util.Date;

/**
 * Ticket class
 */
public class Ticket {

    // region Private fields
    private final int id;

    // default direction
    private Direction direction = Direction.North;

    // default expiration period (12 hours)
    private long expire_period =  12;

    private int customerId = -1;

    private final Date date_created = new Date();
    private final Date date_expires;

    private final String qrcode;

    private boolean valid = true;

    // endregion

    public Ticket() {
        this.id = (int)(date_created.getTime() / 1000);
        this.qrcode = Integer.toHexString(id);
        this.date_expires = new Date(
                new Date().getTime() + this.expire_period * 3600 * 1000);    // (from milliseconds)
    }

    public Ticket(long expire_period) {
        this.id = (int)(date_created.getTime() / 1000);
        this.qrcode = Integer.toHexString(id);
        this.expire_period = expire_period;
        this.date_expires = new Date(
                new Date().getTime() + this.expire_period * 3600 * 1000);    // (from milliseconds)
    }


    // region Getters and setters

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public Direction getDirection() { return direction; }

    public void setCustomerId(int customerId) throws TicketPurchasedException {
        if (this.customerId == -1) this.customerId = customerId;
        else throw new TicketPurchasedException();
    }
    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public int getId() {
        return id;
    }

    public int getCustomerId() {
        return customerId;
    }

    public Date getDate_created() {
        return date_created;
    }

    public Date getDate_expires() {
        return date_expires;
    }

    public String getQrcode() {
        return qrcode;
    }

    public boolean isValid() {
        return valid;
    }


    // endregion

}
