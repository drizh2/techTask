package com.dadry.techtask.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Traffic {
    private Long browserPageViews;
    private Long browserPageViewsB2B;
    private Long mobileAppPageViews;
    private Long mobileAppPageViewsB2B;
    private Long pageViews;
    private Long pageViewsB2B;
    private Long browserSessions;
    private Long browserSessionsB2B;
    private Long mobileAppSessions;
    private Long mobileAppSessionsB2B;
    private Long sessions;
    private Long sessionsB2B;
    private Double buyBoxPercentage;
    private Double buyBoxPercentageB2B;
    private Double orderItemSessionPercentage;
    private Double orderItemSessionPercentageB2B;
    private Double unitSessionPercentage;
    private Double unitSessionPercentageB2B;
    private Integer averageOfferCount;
    private Integer averageParentItems;
    private Integer feedbackReceived;
    private Integer negativeFeedbackReceived;
    private Integer receivedNegativeFeedbackRate;
}
