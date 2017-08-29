package net.michael_j.ddd.core.shared;

import java.io.Serializable;
import java.util.Date;

/**
 * 领域事件
 * Created by Michael Jiang on 16-11-17.
 */
public interface DomainEvent extends Serializable {
    Date occurredTime();
}
