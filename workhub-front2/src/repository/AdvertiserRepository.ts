import HttpRepository from '@/repository/HttpRepository'
import { inject, singleton } from 'tsyringe'
import type PostWrite from '@/entity/post/PostWrite'
import Paging from '@/entity/data/Paging'
import Advertiser from "@/entity/advertiser/Advertiser";

@singleton()
export default class AdvertiserRepository {
  constructor(@inject(HttpRepository) private readonly httpRepository: HttpRepository) {}

  public write(request: PostWrite) {
    return this.httpRepository.post({
      path: '/api/advertisers',
      body: request,
    })
  }

  public get(advertiserId: number) {
    return this.httpRepository.get<Advertiser>({ path: `/api/advertisers/${advertiserId}` }, Advertiser)
  }

  public getList(page: number) {
    return this.httpRepository.getList<Advertiser>(
      {
        path: `/api/advertisers?page=${page}&size=3`,
      },
      Advertiser
    )
  }

  public delete(advertiserId: number) {
    return this.httpRepository.delete({
      path: `/api/advertisers/${advertiserId}`,
    })
  }
}
