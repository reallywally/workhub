import type UserProfile from '@/entity/user/UserProfile'
import { instanceToPlain } from 'class-transformer'
import { singleton } from 'tsyringe'

@singleton()
export default class ProfileRepository {
  public setProfile(profile: UserProfile) {
    const json = instanceToPlain(profile)
    localStorage.setItem('profile', JSON.stringify(json))
  }

  public clear() {
    localStorage.clear()
  }
}
