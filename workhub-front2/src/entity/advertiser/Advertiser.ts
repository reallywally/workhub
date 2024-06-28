import {DateTimeFormatter, LocalDateTime} from '@js-joda/core'
import {Transform} from 'class-transformer'

export default class Advertiser {
    public id = 0
    public businessNumber = ''
    public businessName = ''
    public advertiserName = ''
    public advertiserNameEng = ''
    public businessPhone = ''
    public note = ''

    @Transform(({value}) => LocalDateTime.parse(value, DateTimeFormatter.ISO_LOCAL_DATE_TIME))
    public regDate = LocalDateTime.now()

    public getDisplayRegDate() {
        return this.regDate.format(DateTimeFormatter.ofPattern('yyyy년 MM월 dd일 HH시'))
    }

    public getDisplaySimpleRegDate() {
        return this.regDate.format(DateTimeFormatter.ofPattern('yyyy-MM-dd'))
    }
}
