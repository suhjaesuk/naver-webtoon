package com.naver.webtoon.webtoon.entity;


import com.naver.webtoon.common.time.Timestamped;
import com.naver.webtoon.webtoon.entity.enums.DayOfTheWeek;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PublishDay extends Timestamped {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "publish_day_id")
    private Long id;

    @Column(nullable = false)
    private DayOfTheWeek dayOfTheWeek;

    @Builder
    public PublishDay(Long id, DayOfTheWeek dayOfTheWeek) {
        this.id = id;
        this.dayOfTheWeek = dayOfTheWeek;
    }
}
